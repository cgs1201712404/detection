package com.hptpd.centralpivot.station.vo.app;

import com.google.common.collect.Lists;
import com.hptpd.centralpivot.common.util.AbstractMyBeanUtils;
import com.hptpd.centralpivot.station.domain.ServiceArea;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class ServiceMarker {

    private Coordinate coordinate;

    private Extra extra;


    public static List<ServiceMarker> genarate(Collection<ServiceArea> serviceAreas){

        List<ServiceMarker> serviceMarkers = Lists.newArrayList();
        for (ServiceArea serviceArea:serviceAreas){
            ServiceMarker serviceMarker =new ServiceMarker();
            Extra extra =new Extra();
            Coordinate coordinate =new Coordinate();

            AbstractMyBeanUtils.copyProperties(serviceArea,extra);
            coordinate.setLatitude(serviceArea.getLat());
            coordinate.setLongitude(serviceArea.getLon());

            serviceMarker.setCoordinate(coordinate);
            serviceMarker.setExtra(extra);
            serviceMarkers.add(serviceMarker);
        }

        return serviceMarkers;
    }
}
