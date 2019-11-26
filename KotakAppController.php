<?php

namespace App\Http\Controllers;

use App\Exports\KotakAppExport;
use App\Models\BahanKotakApp;
use App\Models\JenisKotakApp;
use App\Models\KotakApp;
use App\Models\Kunci;
use App\Models\ParentLokasi;
use App\Models\TagPengukuran;
use App\Models\TypeKotakApp;
use App\Http\Requests\StoreKotakAppRequest;
use App\Utilities\GeoJSONFormatter;
use App\Utilities\GeocodeChecker;
use Illuminate\Http\Request;
use Yajra\Datatables\Datatables;

class KotakAppController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $canExport = auth()->user()->role == 'A' ? true : false;
        return view('kotak_app.index', ['export' => $canExport]);
    }
    /**
     * Return datatable as JSON
     * @param  Request $request Request class instance
     * @return JSON             JSON type data
     */
    public function data(Request $request)
    {
        $model = KotakApp::select(['id_pelanggan', 'latitudey', 'longitudex', 'nama_pelanggan', 'streetaddress', 'tarif', 'daya', 'kategori_pelanggan', 'upload_foto', 'id_kotak_app', 'created_by', 'created_at', 'id_kotak_app'])->byUser(auth()->user());
        return Datatables::of($model)
            ->addColumn('column-checkbox', null)
            ->addColumn('action', function (KotakApp $kotakApp) {
                $showRoute = route('kotak_app.view', ['id' => $kotakApp->id_kotak_app]);
                $editRoute = route('kotak_app.edit', ['id' => $kotakApp->id_kotak_app]);
                $viewBtn = "<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"" . __('form.btn_view') . "\" class=\"mr-2\" href=\"$showRoute\"><i class=\"ik ik-eye f-16 text-primary\"></i></a>";
                $editBtn = "<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"" . __('form.btn_edit') . "\" class=\"mr-2\" href=\"$editRoute\"><i class=\"ik ik-edit f-16 text-primary\"></i></a>";
                if (auth()->user()->role != 'A') {
                    $editBtn = "";
                }
                return $viewBtn . $editBtn;
            })
            ->make(true);
    }
    public function modal(Request $request)
    {
        if (!in_array(auth()->user()->username, ["ADM099", "ADM077", "SBA001", "SBA002"])) {
            return response()->json(['status' => false, 'message' => 'You are not authorized to do this action!'], 422);
        }
        try {
            $kotakApp = KotakApp::where('latitudey', '=', $request->query('lat'))
                ->where('longitudex', '=', $request->query('lng'))
                ->firstOrFail();
        } catch (\Illuminate\Database\Eloquent\ModelNotFoundException $e) {
            return response()->json(['status' => false, 'message' => 'Tidak dapat menemukan lokasi yang dimaksud'], 422);
        }
        return response()->json($kotakApp);
    }
    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        $previousPage = $request->query('redirect', route('kotak_app.index'));
        $tagPengukuran = TagPengukuran::all();
        $jenisKotakApp = JenisKotakApp::all();
        $bahanKotakApp = BahanKotakApp::all();
        $typeKotakApp = TypeKotakApp::all();
        $parentLokasi = ParentLokasi::all();
        $kunci = Kunci::all();
        return view('kotak_app.create', compact('previousPage', 'tagPengukuran', 'parentLokasi', 'jenisKotakApp', 'bahanKotakApp', 'typeKotakApp', 'kunci'));
    }
    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(StoreKotakAppRequest $request)
    {
        $upload = null;
        if (!GeocodeChecker::isValid($request->latitudey, $request->longitudex)) {
            $response['status'] = false;
            $response['message'] = __('message.create_data_failed');
            $response['errors'] = [
                "latitudey" => [0 => "Koordinat tidak valid atau berada diluar area Kalimantan Selatan!"]
            ];
            $status_code = 422;
            return response()->json($response, 422);
        }
        if ($request->hasFile('upload_foto')) {
            $unique_id = substr(md5(microtime()), -8);
            $upload = auth()->user()->username . '_' . date('Y_m_d') . '_' . $unique_id . '.' . $request->upload_foto->getClientOriginalExtension();
            if ($request->file('upload_foto')->isValid()) {
                $request->upload_foto->move(public_path('uploads/kotak_app'), $upload);
            }
        }
        $kotakApp = new KotakApp;
        // $kotakApp->description     = $request->description;
        $kotakApp->status          = $request->status;
        $kotakApp->prioritas       = $request->prioritas;
        $kotakApp->serialnum       = $request->serialnum;
        $kotakApp->manufacturer    = $request->manufacturer;
        $kotakApp->vendor1         = $request->vendor1;
        $kotakApp->installdate     = $request->installdate;
        $kotakApp->operatingdate   = $request->operatingdate;
        $kotakApp->streetaddress   = $request->streetaddress;
        $kotakApp->city            = $request->city;
        $kotakApp->latitudey       = $request->latitudey;
        $kotakApp->longitudex      = $request->longitudex;
        $kotakApp->kode_peralatan  = $request->kode_peralatan;
        $kotakApp->nama_pelanggan  = $request->nama_pelanggan;
        $kotakApp->id_pelanggan    = $request->id_pelanggan;
        $kotakApp->mcb             = $request->mcb;
        $kotakApp->tarif           = $request->tarif;
        $kotakApp->daya            = $request->daya;
        $kotakApp->kategori_pelanggan            = $request->kategori_pelanggan;
        // $kotakApp->upload_foto            = $request->upload_foto;
        $kotakApp->nama_penghuni   = $request->nama_penghuni;
        // $kotakApp->id_parent_lokasi   = $request->parent_lokasi;
        // $kotakApp->id_tag_pengukuran  = $request->tag_pengukuran;
        // $kotakApp->id_jenis_kotak_app = $request->jenis_kotak_app;
        // $kotakApp->id_type_kotakapp   = $request->type_kotakapp;
        // $kotakApp->id_bahan_kotakapp  = $request->bahan_kotakapp;
        // $kotakApp->id_kunci           = $request->kunci;
        $kotakApp->sutr_gardu      = $request->sr_tr;
        $kotakApp->upload_foto = $upload;
        $kotakApp->created_by = auth()->user()->username;
        $kotakApp->updated_by = auth()->user()->username;
        $kotakApp->save();
        $response['status'] = false;
        $response['message'] = __('message.create_data_failed');
        $status_code = 422;
        if ($kotakApp->save()) {
            // tabel app_sr
            $app_dari = $kotakApp->id_kotak_app;
            $app_ke = $request->app_ke;
            $sr_app_panjang = $request->sr_app_panjang;
            $sr_app_warna = $request->sr_app_warna;
            \DB::insert('app_sr')->insert([
                'app_dari' => $app_dari,
                'app_ke' => $app_ke,
                'sr_app_Panjang' => $sr_app_panjang,
                'sr_app_warna' => $sr_app_warna,
            ]);
        }
        return response()->json($response, $status_code);
    }
    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function view(Request $request, $id)
    {
        try {
            $kotakApp = KotakApp::byUser(auth()->user())->findOrFail($id);
            $previousPage = $request->query('redirect', route('kotak_app.index'));
        } catch (ModelNotFoundException $e) {
            abort(403, 'Data Gardu tidak ditemukan');
        }
        return view('kotak_app.view', compact('kotakApp', 'previousPage'));
    }
    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit(Request $request, $id)
    {
        if (auth()->user()->role != "A") {
            return redirect()->back();
        }
        try {
            $kotakApp = KotakApp::byUser(auth()->user())->findOrFail($id);
            $tagPengukuran = TagPengukuran::all();
            $jenisKotakApp = JenisKotakApp::all();
            $bahanKotakApp = BahanKotakApp::all();
            $typeKotakApp = TypeKotakApp::all();
            $parentLokasi = ParentLokasi::all();
            $kunci = Kunci::all();
            $previousPage = $request->query('redirect', route('kotak_app.index'));
        } catch (ModelNotFoundException $e) {
            abort(403, 'Data Kotak App tidak ditemukan');
        }
        return view('kotak_app.edit', compact('kotakApp', 'tagPengukuran', 'jenisKotakApp', 'bahanKotakApp', 'typeKotakApp', 'parentLokasi', 'kunci', 'previousPage'));
    }
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request)
    {
        $id_kotak_app = $request->id_kotak_app;
        if (is_null($id_kotak_app)) {
            return response()->json(['status' => false, 'message' => 'ID Gardu tidak ditemukan.'], 422);
        }
        $upload = null;
        if (!GeocodeChecker::isValid($request->latitudey, $request->longitudex)) {
            $response['status'] = false;
            $response['message'] = __('message.create_data_failed');
            $response['errors'] = [
                "latitudey" => [0 => "Koordinat tidak valid atau berada diluar area Kalimantan Selatan!"]
            ];
            $status_code = 422;
            return response()->json($response, 422);
        }
        if ($request->hasFile('upload_foto')) {
            $unique_id = substr(md5(microtime()), -8);
            $upload = auth()->user()->username . '_' . date('Y_m_d') . '_' . $unique_id . '.' . $request->upload_foto->getClientOriginalExtension();
            if ($request->file('upload_foto')->isValid()) {
                $request->upload_foto->move(public_path('uploads/kotak_app'), $upload);
            }
        }
        $kotakApp = KotakApp::findOrFail($id_kotak_app);
        // $kotakApp->description     = $request->description;
        $kotakApp->status          = $request->status;
        $kotakApp->prioritas       = $request->prioritas;
        $kotakApp->serialnum       = $request->serialnum;
        $kotakApp->manufacturer    = $request->manufacturer;
        $kotakApp->vendor1         = $request->vendor1;
        $kotakApp->installdate     = $request->installdate;
        $kotakApp->operatingdate   = $request->operatingdate;
        $kotakApp->streetaddress   = $request->streetaddress;
        $kotakApp->city            = $request->city;
        $kotakApp->latitudey       = $request->latitudey;
        $kotakApp->longitudex      = $request->longitudex;
        $kotakApp->kode_peralatan  = $request->kode_peralatan;
        $kotakApp->nama_pelanggan  = $request->nama_pelanggan;
        $kotakApp->id_pelanggan    = $request->id_pelanggan;
        $kotakApp->mcb             = $request->mcb;
        $kotakApp->tarif           = $request->tarif;
        $kotakApp->daya            = $request->daya;
        $kotakApp->kategori_pelanggan            = $request->kategori_pelanggan;
        $kotakApp->upload_foto            = $request->upload_foto;
        $kotakApp->nama_penghuni   = $request->nama_penghuni;
        // $kotakApp->id_parent_lokasi   = $request->parent_lokasi;
        $kotakApp->id_tag_pengukuran  = $request->tag_pengukuran;
        $kotakApp->id_jenis_kotak_app = $request->jenis_kotak_app;
        $kotakApp->id_type_kotakapp   = $request->type_kotakapp;
        $kotakApp->id_bahan_kotakapp  = $request->bahan_kotakapp;
        $kotakApp->id_kunci           = $request->kunci;
        if ($request->hasFile('upload_foto')) {
            $kotakApp->upload_foto = $upload;
        }
        $kotakApp->updated_by = auth()->user()->username;
        $kotakApp->save();
        $response['status'] = false;
        $response['message'] = __('message.update_data_failed');
        $status_code = 422;
        if ($kotakApp->save()) {
            $response['status'] = true;
            $response['message'] = __('message.update_data_success');
            $status_code = 200;
        }
        return response()->json($response, $status_code);
    }
    public function updateCoordinate(Request $request)
    {
        try {
            $kotakApp = KotakApp::findOrFail($request->input('id', null));
            $kotakApp->latitudey  = $request->lat;
            $kotakApp->longitudex = $request->lng;
            $kotakApp->updated_by = auth()->user()->username;
            $kotakApp->save();
            $response['status'] = false;
            $response['message'] = __('message.update_data_failed');
            $status_code = 422;
            if ($kotakApp->save()) {
                $response['status'] = true;
                $response['message'] = __('message.update_data_success');
                $status_code = 200;
            }
            return response()->json($response, 200);
        } catch (\Illuminate\Database\Eloquent\ModelNotFoundException $e) {
            return response()->json(['status' => false, 'message' => 'Tidak dapat menemukan lokasi yang dimaksud'], 422);
        }
    }
    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
    public function latlng(Request $request)
    {
        ini_set('memory_limit', '512M');
        $kotakAppData = \Cache::remember('kotak_app:latlng:all', 900, function () {
            $kotakApp = KotakApp::select(['id_kotak_app', 'latitudey', 'longitudex'])->get();
            return $kotakApp->map(function ($item, $key) {
                $properties['type'] = 'kotak_app';
                $properties['id'] = $item->id_kotak_app;
                $coordinates = [(float) $item->latitudey, (float) $item->longitudex];
                // return GeoJSONFormatter::pointToArray($coordinates, $properties);
                return $coordinates;
            })->all();
        });
        // return response()->json(GeoJSONFormatter::toGeoJSON($kotakAppData));
        return response()->json($kotakAppData);
    }
    public function export(Request $request)
    {
        if (auth()->user()->role != 'A') {
            return redirect()->back();
        }
        ini_set('memory_limit', -1);
        $start = $request->input('start', null);
        $end = $request->input('end', null);
        return new KotakAppExport($start, $end);
    }
    public function zipImages(Request $request)
    {
        if (auth()->user()->role != 'A') {
            return redirect()->back();
        }
        $zipName = "kotak_app_foto.zip";
        $ids = $request->ids;
        if (is_array($ids) && count($ids) > 30) {
            echo "Only maximum 30 images can be exported.";
            return;
        }
        try {
            $kotakApp = KotakApp::find($ids);
            if (is_null($kotakApp)) {
                echo "Images not found.";
                return;
            }
            unlink($zipName);
            $zip = new \ZipArchive();
            if ($zip->open(public_path($zipName), \ZipArchive::CREATE) !== TRUE) {
                echo "Cannot create zip file.";
                return;
            }
            foreach ($kotakApp as $key => $item) {
                $zip->addFile(public_path("uploads/kotak_app/" . $item->upload_foto), $item->upload_foto);
            }
            $zip->close();
            return response()->download($zipName);
        } catch (\Exception $e) {
            echo "Request cannot be processed.";
            return;
        }
    }
}
