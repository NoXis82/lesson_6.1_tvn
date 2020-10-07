package ru.netology.service
import ru.netology.attachments.*
import ru.netology.wall.*


class WallService {
    private var postsArray = emptyArray<Post>()
    private var idPost = 0

    fun add(post: Post): Post {
        idPost += 1
        post.id = idPost
        postsArray += post
        return postsArray.last()
    }

    fun update(post: Post): Boolean {
        for ((index, posts) in postsArray.withIndex()) {
            if (post.id == posts.id) {
                postsArray[index] = post.copy(
                        id = posts.id,
                        date = posts.date
                )
                return true
            }
        }
        return false
    }

    fun readArray() {
        for (post in postsArray) {
            val attachments: Array<Attachments> = post.attachments ?: emptyArray()
            for (attachment in attachments) {
                when (attachment) {
                    is NoteAttachments -> {
                        val note: Note = attachment.note
                        println("date: ${note.date}")
                        println("text: ${note.text}")
                        println("title: ${note.title}")
                    }
                    is PhotoAttachments -> {
                        val photo: Photo = attachment.photo
                        println("id: ${photo.albumId}")
                        println("text: ${photo.text}")
                        println("date: ${photo.date}")
                    }
                    is AudioAttachments -> {
                        val audio: Audio = attachment.audio
                    }
                    is EventAttachments -> {
                        val event: Event = attachment.event
                    }
                    is VideoAttachments -> {
                        val video: Video = attachment.video
                    }
                }
            }
        }
    }
}