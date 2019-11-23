package com.bst.spbseekerserver.model.dto.route

import com.bst.spbseekerserver.model.dto.category.CategoryDto
import com.bst.spbseekerserver.model.dto.meta.MetaDto
import io.swagger.annotations.ApiModelProperty

data class RouteDto(
        @ApiModelProperty(notes = "Route id")
        val id: Long,
        @ApiModelProperty(notes = "Provided route name")
        val name: String,
        @ApiModelProperty(notes = "List of route images")
        val imgUrlList: List<String>,
        @ApiModelProperty(notes = "Description of route")
        val description: String,
        @ApiModelProperty(notes = "Category of route")
        val category: CategoryDto,
        @ApiModelProperty(notes = "Meta information of route")
        val meta: MetaDto
)
