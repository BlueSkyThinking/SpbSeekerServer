package com.bst.spbseekerserver.controller.api

import com.bst.spbseekerserver.model.dto.CategoryDto
import com.bst.spbseekerserver.model.dto.TravelDto
import com.bst.spbseekerserver.model.entity.Travel
import com.bst.spbseekerserver.service.api.CategoryService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@Api(value = "category", description = "Rest API for categories", tags = ["Category API"])
@RequestMapping(value = ["/api/v1/category"], produces = [MediaType.APPLICATION_JSON_VALUE])
class CategoryController(val categoryService: CategoryService) {
    @ApiOperation(value = "Fetching one category by id", response = Travel::class)
    @ApiResponses(
            value = [ApiResponse(code = 200, message = "OK"), ApiResponse(code = 404, message = "The resource not found")]
    )
    @GetMapping("/{id}")
    fun get(@PathVariable("id") categoryId: Long): CategoryDto = categoryService.getCategory(categoryId)

    @ApiOperation(value = "Fetching all categories", responseContainer = "List", response = TravelDto::class)
    @ApiResponses(
            value = [ApiResponse(code = 200, message = "OK"), ApiResponse(code = 404, message = "The resource not found")]
    )
    @GetMapping
    fun getAll(): List<CategoryDto> = categoryService.getAllCategories()

    @ApiOperation(value = "Save category", response = TravelDto::class)
    @ApiResponses(
            value = [ApiResponse(code = 200, message = "OK"), ApiResponse(code = 404, message = "The resource not found")]
    )
    @PostMapping
    fun save(@RequestBody category: CategoryDto): CategoryDto = categoryService.saveCategory(category)

    @ApiOperation(value = "Delete one category by id", response = Long::class)
    @ApiResponses(
            value = [ApiResponse(code = 200, message = "OK"), ApiResponse(code = 404, message = "The resource not found")]
    )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") categoryId: Long): Long = categoryService.deleteCategory(categoryId)
}