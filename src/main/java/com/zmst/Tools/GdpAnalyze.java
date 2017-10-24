package com.zmst.Tools;

import java.util.List;

import com.zmst.Domain.Gdp;
import com.zmst.Domain.GdpMiddleTable;
import com.zmst.Domain.LargeAndClassDictionary;
import com.zmst.Domain.LargeGdp;
import com.zmst.Domain.SubGdp;

public class GdpAnalyze {

	public static void sloveLSMGdp(List<Gdp> gdpList, List<GdpMiddleTable> gdpMiddleList, List<SubGdp> subGdpList,
			List<LargeAndClassDictionary> largeAndClass, List<LargeGdp> largeGdpList, String year, String place) {
		// TODO Auto-generated method stub
      for(Gdp gdp:gdpList ){
			
			if(gdp.getGdpcode().length()==2){
				LargeGdp largeGdp = new LargeGdp();
				largeGdp.setLacode(gdp.getGdpcode());
				largeGdp.setLagdp(gdp.getGdp());
				largeGdp.setLaname(gdp.getGdpname());
				largeGdp.setPlace(place);
				largeGdp.setYear(year);
				largeGdpList.add(largeGdp);
			}else if(gdp.getGdpcode().length()==4){
				SubGdp subGdp = new SubGdp();
				subGdp.setPlace(place);
				subGdp.setYear(year);
				subGdp.setSmcode(gdp.getGdpcode());
				subGdp.setSmname(gdp.getGdpname());
				subGdp.setSmgdp(gdp.getGdp());
				subGdpList.add(subGdp);
			} 
			
		}
		
		for(Gdp gdp:gdpList){
			if(gdp.getGdpcode().length()>4){
				String[] source = gdp.getGdpcode().split("-");
				double mix = Integer.valueOf(source[0]);
				double max = Integer.valueOf(source[2]);
				double gdps = gdp.getGdp();
				for(LargeGdp largeGdp:largeGdpList){
					int gdpCode = Integer.valueOf(largeGdp.getLacode());
					if(gdpCode>=mix&&gdpCode<=max){
						gdps=gdps-largeGdp.getLagdp();
					}else{
						continue;
					}
				}
				
				if(gdps>0){
					GdpMiddleTable gdpMiddleTable = new GdpMiddleTable();
					gdpMiddleTable.setGdp(gdps);
					gdpMiddleTable.setPlace(place);
					gdpMiddleTable.setLoli(mix);
					gdpMiddleTable.setUpli(max);
					gdpMiddleList.add(gdpMiddleTable);
				}else{
					continue;
				}
				 
			}
		}
		
	}

}
