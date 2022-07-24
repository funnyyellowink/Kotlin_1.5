data class Note(
    var title : String,
    var text : String
) {
    var nid : Int = 0
    var privacy : Int = 0
    var commentPrivacy : Int = 0
    var privacyView : String = "All"
    var privacyComment : String = "All"
    var noteComments  = mutableListOf<NoteComment>()
}

data class NoteComment(
    var noteId : Int,
    val message: String
) {
    var ownerId : Int = 0
    var replyTo : Int = 0
    var guid : String = ""
}

class NoteNotFoundException(message: String): RuntimeException(message)

object NoteService {
    var notes = mutableListOf<Note>()
    var comments = mutableListOf<Comment>()

    fun add(title: String,text: String) : Int {
        notes.add(Note(title,text))
        notes.last().nid = notes.size
        return notes.last().nid
    }
    //Тут надо поправить два ID
    fun createComment(noteId: Int, message: String, nid: Int) {
        var noteToComment = notes.find { it.nid == nid }
        noteToComment?.noteComments?.add(NoteComment(noteId,message))
    }

    fun delete(id: Int) { notes.remove(notes.find { it.nid == id }) }

    fun deleteComment() {}

    fun edit(id: Int, title: String, text: String) {}

    fun editComment() {}

    fun get() {}

    fun getById(id: Int): Note? {return notes.find { it.nid == id } ?: throw NoteNotFoundException("180")}

    fun getComments() {}

    fun getFriendsNotes() {}

    fun restoreComment() {}
}

fun main() {
    NoteService.add("Первая заметка","Текст первой заметки")
    println(NoteService.notes.last().text)
    println(NoteService.notes.last().nid)
    NoteService.add("Вторая заметка","Текст второй заметки")
    println(NoteService.notes.last().text)
    println(NoteService.notes.last().nid)
    NoteService.add("Третья заметка","Текст третьей заметки")
    println(NoteService.notes.last().text)
    println(NoteService.notes.last().nid)
    NoteService.add("Четвертая заметка","Текст четвертой заметки")
    println(NoteService.notes.last().text)
    println(NoteService.notes.last().nid)
    println(NoteService.getById(3)?.text)
    try { println(NoteService.getById(5)?.text) } catch (e: NoteNotFoundException) { println("180 error")}
    NoteService.delete(4)
    println(NoteService.notes.last().text)
    println(NoteService.notes.last().nid)
    try { println(NoteService.getById(4)?.text) } catch (e: NoteNotFoundException) { println("180 error")}
    NoteService.createComment(1,"Первый коммент",3)
    println(NoteService.notes.last().noteComments.last().message)
    //println(NoteService.get())
}