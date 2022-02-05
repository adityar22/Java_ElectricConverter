package com.electric.electric_project;

//Simport org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class ElectricProjectApplication {
	
	public static void main(String[] args) {
		//SpringApplication.run(ElectricProjectApplication.class, args);
		convertDaya cvtDaya = new convertDaya();
		redam rdm = new redam();
		convertTegangan cvtVolt = new convertTegangan();
		penguatan kuat = new penguatan();

		Scanner myObj = new Scanner(System.in);
		int jumlahDaya;
		
		System.out.println("Masukkan jumlah daya: ");
		jumlahDaya = myObj.nextInt();

		double[] daya = new double[jumlahDaya];
		double[] dayaRel = new double[jumlahDaya];
		double[] redaman = new double[jumlahDaya-1];

		System.out.println("Masukkan nilai data daya: ");
		for(int i=0; i<jumlahDaya; i++){
			daya[i] = myObj.nextDouble();
		}
		System.out.println("Daya absolute sebagai berikut:");
		System.out.println(Arrays.toString(daya)+" watt");
		for(int i=0; i<jumlahDaya; i++){
			dayaRel[i] = cvtDaya.dayaconvert(daya[i]);
		}
		System.out.println("akan bersesuaian dengan daya relatif: ");
		System.out.println(Arrays.toString(dayaRel)+" dBw");
		for(int i=0; i<jumlahDaya-1; i++){
			redaman[i] = rdm.findRedam(dayaRel[i], dayaRel[i+1]);
		}
		System.out.println("memiliki Redaman atau gain: ");
		System.out.println(Arrays.toString(redaman)+" dB");

		System.out.println("Masukkan jumlah tegangan: ");
		int jumlahVolt = myObj.nextInt();

		double[] tegangan = new double[jumlahVolt];
		double[] teganganRel = new double[jumlahVolt];
		double[] kuatan = new double[jumlahVolt-1];

		System.out.println("Masukkan nilai data tegangan: ");
		for(int i=0; i<jumlahVolt; i++){
			tegangan[i] = myObj.nextDouble();
		}
		System.out.println("Tegangan absolute sebagai berikut: ");
		System.out.println(Arrays.toString(tegangan)+" Volt");
		for(int i=0; i<jumlahVolt; i++){
			teganganRel[i] = cvtVolt.teganganCvt(tegangan[i]);
		}
		System.out.println("akan bersesuaian dengan tegangan relatif: ");
		System.out.println(Arrays.toString(teganganRel)+" dBV");
		for(int i=0; i<jumlahVolt-1; i++){
			kuatan[i] = kuat.penguatanTegangan(teganganRel[i], teganganRel[i+1]);
		}
		System.out.println("memiliki Redaman atau Gain: ");
		System.out.println(Arrays.toString(kuatan)+" dB");
	}

}
