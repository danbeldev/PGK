package ru.pgk63.core_common.api.journal.model

import ru.pgk63.core_common.api.subject.model.Subject
import ru.pgk63.core_common.api.teacher.model.Teacher

data class JournalSubjectResponse(
    val currentPage:Int,
    val totalPages:Int,
    val pageSize:Int,
    val totalCount:Int,
    val hasPrevious:Boolean,
    val hasNext:Boolean,
    val results:List<JournalSubject>
)

data class JournalSubject(
    val id:Int,
    val hours:Int,
    val subject:Subject,
    val teacher:Teacher,
    val journal: Journal,
    val topics:List<JournalTopic>,
    val rows:List<JournalRow>
)