package devanir.soaresjunior.challenge_jsonplaceholder.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import devanir.soaresjunior.challenge_jsonplaceholder.common.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class AlbumEntity(
    var userId: Int,
    @PrimaryKey var id: Int? = null,
    var title: String
)