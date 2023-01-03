package ru.pgk63.core_common.api.group.repository

import ru.pgk63.core_common.Constants.PAGE_SIZE
import ru.pgk63.core_common.api.group.GroupApi
import ru.pgk63.core_common.api.group.model.Group
import ru.pgk63.core_common.api.group.model.GroupResponse
import ru.pgk63.core_common.api.student.model.StudentResponse
import ru.pgk63.core_common.common.response.ApiResponse
import ru.pgk63.core_common.common.response.Result
import javax.inject.Inject

class GroupRepository @Inject constructor(
    private val groupApi: GroupApi,
) : ApiResponse() {

    suspend fun getAll(
        search: String? = null,
        course: List<Int>? = null,
        number: List<Int>? = null,
        specialityIds: List<Int>? = null,
        departmentIds: List<Int>? = null,
        classroomTeacherIds: List<Int>? = null,
        deputyHeadmaIds: List<Int>? = null,
        headmanIds: List<Int>? = null,
        pageNumber: Int = 1,
        pageSize: Int = PAGE_SIZE,
    ): GroupResponse {
        return groupApi.getAll(
            search = search,
            course = course,
            number = number,
            specialityIds = specialityIds,
            departmentIds = departmentIds,
            classroomTeacherIds = classroomTeacherIds,
            deputyHeadmaIds = deputyHeadmaIds,
            headmanIds = headmanIds,
            pageNumber = pageNumber,
            pageSize = pageSize
        )
    }

    suspend fun getById(id: Int): Result<Group> {
        return safeApiCall { groupApi.getById(id) }
    }

    suspend fun getStudentByGroupId(
        id: Int,
        pageNumber: Int = 1,
        pageSize: Int = PAGE_SIZE
    ): StudentResponse = groupApi.getStudentByGroupId(id, pageNumber, pageSize)
}