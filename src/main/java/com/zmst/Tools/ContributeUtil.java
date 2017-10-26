package com.zmst.Tools;

import java.util.List;

import com.zmst.Domain.LargeGdp;
import com.zmst.Domain.LargeTravelGdp;
import com.zmst.Domain.TravelLargeGdpContribute;

public class ContributeUtil {

	public static void getLargeGdpContribute(String year, String place,
			List<TravelLargeGdpContribute> travelLargeGdpContributeList, List<LargeTravelGdp> largeTravelGdpList,
			List<LargeGdp> largeGdp) {
		// TODO Auto-generated method stub
		double rate=0;
		for(int i=0;i<largeGdp.size();i++){
			rate=0;
			for(int j=0;j<largeTravelGdpList.size();j++){
				if(largeGdp.get(i).getLacode().equals(largeTravelGdpList.get(j).getLacode())){
					
					TravelLargeGdpContribute travelLargeGdpContribute = new TravelLargeGdpContribute();
					travelLargeGdpContribute.setGdp(largeGdp.get(i).getLagdp());
					travelLargeGdpContribute.setTrgdp(largeTravelGdpList.get(j).getLtgdp());
					if(largeGdp.get(j).getLagdp()!=0){
					rate=largeTravelGdpList.get(j).getLtgdp()/largeGdp.get(i).getLagdp();
					}
					
					travelLargeGdpContribute.setRate(rate);
					travelLargeGdpContribute.setYear(year);
					travelLargeGdpContribute.setPlace(place);
					travelLargeGdpContribute.setLaname(largeGdp.get(i).getLaname());
					travelLargeGdpContribute.setLacode(largeGdp.get(i).getLacode());
					
					travelLargeGdpContributeList.add(travelLargeGdpContribute);
				}
				
				
			}
		}
		
	}

}
