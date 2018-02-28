import java.io.*;

public class bank
{
	//	Variable
	int saldo;
	
	//	Konstruktor
	public bank(int saldo)
	{
		this.saldo = saldo;
	}
	
	//	Method simpanUang
	public void simpanUang(int value)
	{
		saldo += value;
	}
	
	//	Method ambilUang
	public void ambilUang(int value)
	{
		saldo -= value;
	}
	
	//	Method getSaldo
	public int getSaldo()
	{
		return saldo;
	}
}