package com.bst.spbseekerserver.model.dto.hint

import io.swagger.annotations.ApiModelProperty

data class UpdateHintDto(
        @ApiModelProperty(notes = "Provided hint name")
        val name: String?,
        @ApiModelProperty(notes = "Image url of hint")
        val imgUrl: String?,
        @ApiModelProperty(notes = "Full Description of this hint")
        val description: String?,
        @ApiModelProperty(notes = "Short Description of this hint")
        val shortDescription: String?
)
