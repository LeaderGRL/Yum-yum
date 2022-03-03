package com.example.yumyum.model.network.API

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class Deserializer : JsonDeserializer<JsonObject>{
    var str: String = ""
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): JsonObject {
        return json.asJsonObject.get("name").asJsonObject
    }
}