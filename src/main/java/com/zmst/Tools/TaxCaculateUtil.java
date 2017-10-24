package com.zmst.Tools;

import java.util.ArrayList;
import java.util.List;

import com.zmst.Domain.AllCodeDictionary;
import com.zmst.Domain.CentralTax;
import com.zmst.Domain.ClassTax;
import com.zmst.Domain.LandTax;
import com.zmst.Domain.LargeAndClassDictionary;
import com.zmst.Domain.LargeMiddleClass;
import com.zmst.Domain.LargeTax;
import com.zmst.Domain.SubTax;

public class TaxCaculateUtil {

	public static void getSubTax(List<SubTax> subTaxList, String year, String place, List<LandTax> landTaxList,
			List<CentralTax> centralTaxList) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<landTaxList.size();i++){
			SubTax subTax = new SubTax();
			subTax.setLacode(landTaxList.get(i).getLacode());
            subTax.setSmcode(landTaxList.get(i).getSmcode());
            subTax.setSmname(landTaxList.get(i).getSmname());
            subTax.setPlace(place);
            subTax.setYear(year);
            subTax.setSmtax(landTaxList.get(i).getLatax());
		    subTaxList.add(subTax);
		} 
			
		int log = 0;
		for(int i=0;i<centralTaxList.size();i++){
				  log=0;
				  SubTax subTax = new SubTax();
				  double tax=0;
			for(int j=0;j<subTaxList.size();j++){
				
				if(subTaxList.get(i).getSmcode().equals(centralTaxList.get(i).getSmcode())){
					 
					 tax= subTaxList.get(i).getSmtax()+centralTaxList.get(i).getCntax();
					 subTaxList.get(i).setSmtax(tax);
					log=1;
				}
				
				
			}
			
			if(log==0){
				  
				tax= centralTaxList.get(i).getCntax();
				subTax.setLacode(centralTaxList.get(i).getLacode());
				subTax.setPlace(place);
				subTax.setYear(year);
				subTax.setSmname(subTaxList.get(i).getSmname());
				subTax.setSmcode(centralTaxList.get(i).getSmcode());
				subTax.setSmtax(tax);
				subTaxList.add(subTax);
				
			}
			
		}
		
	}

	public static void getLargeTax(List<AllCodeDictionary> largeLineList, String place, String year,
			List<LargeTax> largeTaxList, List<SubTax> subTaxList) {
		// TODO Auto-generated method stub
		
		for(AllCodeDictionary code:largeLineList){
			LargeTax largeTax = new LargeTax();
			largeTax.setLacode(code.getIncode());
			largeTax.setLaname(code.getInname());
			largeTax.setPlace(place);
			largeTax.setYear(year);
			
		}
		
		for(int i=0;i<largeTaxList.size();i++){
			double tax=0;
			for(int j=0;j<subTaxList.size();j++){
				if(largeTaxList.get(i).getLacode().equals(subTaxList.get(j).getSmcode().substring(0,2)));
				{
					tax = tax + subTaxList.get(j).getSmtax();
				}
			}
			largeTaxList.get(i).setLatax(tax);
		}
		
	}

	public static void getClassTax(List<LargeTax> largeTaxList, List<AllCodeDictionary> classLineList, List<LargeAndClassDictionary> classDidctionary,
			String place, String year, List<ClassTax> classTaxList) {
		// TODO Auto-generated method stub
		List<LargeMiddleClass>largeMiddleTax = new ArrayList<LargeMiddleClass>();
		for(AllCodeDictionary classCode:classLineList){
			ClassTax classTax = new ClassTax();
			classTax.setPlace(place);
			classTax.setYear(year);
			classTax.setClcode(classCode.getIncode());
			classTax.setClname(classCode.getInname());
			classTaxList.add(classTax);
		}
		
		for(LargeAndClassDictionary lcd:classDidctionary){
			LargeMiddleClass lm = new LargeMiddleClass();
			lm.setClasscode(lcd.getClcode());
			lm.setLacode(lcd.getLacode());
			largeMiddleTax.add(lm);
		}
		
		for(int i=0;i<largeMiddleTax.size();i++){
			for(int j=0;j<largeTaxList.size();j++){
				if(largeMiddleTax.get(i).getLacode().equals(largeTaxList.get(j).getLacode())){
					largeMiddleTax.get(i).setLatax(largeTaxList.get(i).getLatax());
				}else{
					continue;
				}
			}
		}
		
		double tax=0;
		for(int i=0;i<classTaxList.size();i++){
		
			tax=0;
			for(int j=0;j<largeMiddleTax.size();j++){
				if(classTaxList.get(i).getClcode().equals(largeMiddleTax.get(j).getClasscode())){
					tax=tax+largeMiddleTax.get(j).getLatax();
				}
			}
			
			classTaxList.get(i).setCltax(tax);
		}
		
	}

}
