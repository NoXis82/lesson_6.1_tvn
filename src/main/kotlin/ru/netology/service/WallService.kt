package ru.netology.service
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

}