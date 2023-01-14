package ru.pgk63.core_common.api.journal.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.pgk63.core_common.Constants.PAGE_SIZE
import ru.pgk63.core_common.api.journal.JournalApi
import ru.pgk63.core_common.api.journal.model.*
import ru.pgk63.core_common.api.journal.paging.JournalPagingSource
import ru.pgk63.core_common.api.journal.paging.JournalRowPagingSource
import ru.pgk63.core_common.api.journal.paging.JournalSubjectPagingSource
import ru.pgk63.core_common.api.journal.paging.JournalTopicPagingSource
import ru.pgk63.core_common.common.response.ApiResponse
import javax.inject.Inject

class JournalRepository @Inject constructor(
    private val journalApi: JournalApi
): ApiResponse() {

    fun getAll(
        course:List<Int>? = null,
        semesters:List<Int>? = null,
        groupIds:List<Int>? = null,
        specialityIds:List<Int>? = null,
        departmentIds:List<Int>? = null
    ): Flow<PagingData<Journal>> {
        return Pager(PagingConfig(pageSize = PAGE_SIZE)){
            JournalPagingSource(
                journalApi = journalApi,
                course = course,
                semesters = semesters,
                groupIds = groupIds,
                specialityIds = specialityIds,
                departmentIds = departmentIds,
            )
        }.flow
    }

    fun getJournalSubjects(
        journalId:Int? = null
    ): Flow<PagingData<JournalSubject>> {
        return Pager(PagingConfig(pageSize = PAGE_SIZE)){
            JournalSubjectPagingSource(
                journalApi = journalApi,
                journalId = journalId
            )
        }.flow
    }

    fun getJournalTopics(
        journalSubjectId:Int? = null
    ): Flow<PagingData<JournalTopic>> {
        return Pager(PagingConfig(pageSize = PAGE_SIZE)){
            JournalTopicPagingSource(
                journalApi = journalApi,
                journalSubjectId = journalSubjectId
            )
        }.flow
    }

    fun getJournalRow(
        journalSubjectId:Int? = null,
        studentIds:List<Int>? = null,
        evaluation: JournalEvaluation? = null
    ): Flow<PagingData<JournalRow>> {
        return Pager(PagingConfig(pageSize = PAGE_SIZE)){
            JournalRowPagingSource(
                journalApi = journalApi,
                journalSubjectId = journalSubjectId,
                studentIds = studentIds,
                evaluation = evaluation
            )
        }.flow
    }
}