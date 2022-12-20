package ru.pgk63.core_common.api.techSupport.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import ru.pgk63.core_common.api.techSupport.model.GetMessageListParameters
import ru.pgk63.core_common.api.techSupport.model.Message
import ru.pgk63.core_common.api.techSupport.webSocket.MessagesWebSocket

class MessagePagingSource(
    private val messagesWebSocket: MessagesWebSocket
): PagingSource<Int, Message>() {

    override fun getRefreshKey(state: PagingState<Int, Message>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Message> {
        return try {
            val nextPage = params.key ?: 1

            messagesWebSocket.setMessagesParameters(GetMessageListParameters(pageNumber = nextPage))

            val messageResponse = messagesWebSocket.messageResponse


            Log.e("MessagePagingSource",messageResponse.toString())

            LoadResult.Page(
                data = messageResponse?.results ?: listOf(),
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        }catch (e:Exception){
            Log.e("MessagePagingSource",e.message.toString())
            LoadResult.Error(e)
        }
    }
}