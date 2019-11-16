package com.bst.spbseekerserver.service.api

import com.bst.spbseekerserver.model.dto.point.PointDto
import com.bst.spbseekerserver.model.entity.Point

interface PointService {
    fun getPoint(id: Long): PointDto
    fun getPointEntity(id: Long): Point
    fun getAllPoints(): List<PointDto>
    fun getAllPointsByRouteId(routeId: Long): List<PointDto>
    fun deletePoint(id: Long): Long
    fun savePoint(point: PointDto): PointDto
    fun getNearestPoint(latitude: Double, longitude: Double): PointDto
}
