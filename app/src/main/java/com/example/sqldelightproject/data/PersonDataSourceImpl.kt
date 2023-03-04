package com.example.sqldelightproject.data

import com.example.sqldelightproject.PersonDatabse
import com.example.sqldelightproject.util.switchToIO
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import persondb.PersonEntity

class PersonDataSourceImpl(
    db: PersonDatabse  //This name is generated according to specified name in gradle
): PersonDataSource {

    private val queries = db.personEntityQueries 

    override suspend fun getPersonById(id: Long): PersonEntity? = switchToIO {
        queries.getPersonById(id).executeAsOneOrNull()
    }


    override fun getAllPersons(): Flow<List<PersonEntity>> = queries.getAllPersons().asFlow().mapToList(Dispatchers.IO)

    override suspend fun deletePersonById(id: Long) = switchToIO {
        queries.deletePersonById(id)
    }

    override suspend fun insertPerson(firstName: String, lastName: String, id: Long?) = switchToIO {
        queries.insertPerson(firstName = firstName, lastName = lastName, id = id)
    }
}