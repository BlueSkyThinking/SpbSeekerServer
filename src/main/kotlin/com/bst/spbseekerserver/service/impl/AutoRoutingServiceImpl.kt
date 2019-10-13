package com.bst.spbseekerserver.service.impl

import com.bst.spbseekerserver.model.dto.TravelDto
import com.bst.spbseekerserver.model.location.Location
import com.bst.spbseekerserver.service.api.AutoRoutingService
import com.bst.spbseekerserver.service.api.PointService
import com.bst.spbseekerserver.service.api.TravelService
import org.springframework.stereotype.Service
import kotlin.random.Random


@Service
class AutoRoutingServiceImpl(val pointService: PointService, val travelService: TravelService) : AutoRoutingService {
    val NEAREST_POINT_METERS = 1000

    override fun generateTravel(latitude: Double, longitude: Double): TravelDto {
        val current = Location(latitude, longitude)
        val nearest = pointService.getNearestPoint(latitude, longitude)

        val points = pointService.getAllPoints()
        val startedPoints = points.filter { Location(it.latitude, it.longitude).distanceTo(Location(nearest.latitude, nearest.longitude)) < NEAREST_POINT_METERS }
        val start = startedPoints[Random.nextInt(startedPoints.size)]

        val left = points.filter { start.longitude < nearest.longitude }

        return TravelDto(0, "", 0, "", "", 0, null, null)
    }

}