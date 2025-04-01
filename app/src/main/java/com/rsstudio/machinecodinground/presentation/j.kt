package com.rsstudio.machinecodinground.presentation


data class ProfileInfo(
    val profileData : ProfileData
)
data class ProfileData(
    val name : String,
    val age : String,
    val occupation : String,
    val userImage : String,
    val showOffYourPersonality : List<QuestionItem>
)

data class QuestionItem(
    val id : String,
    val question : String,
    val answer : String
)
