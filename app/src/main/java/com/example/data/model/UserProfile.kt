package com.example.data.model

/**
 * User Profile information for customizing I-Ching consultations.
 */
data class UserProfile(
    val age: String = "",
    val gender: String = "",
    val customGender: String = "",
    val educationLevel: String = "",
    val iChingExperience: String = "",
    val isCompleted: Boolean = false
) {
    companion object {
        val GENDER_OPTIONS = listOf(
            "Woman",
            "Man",
            "Non-binary",
            "Self-describe",
            "Prefer not to say"
        )

        val EDUCATION_OPTIONS = listOf(
            "High School",
            "Some College / Vocational",
            "Bachelor's Degree",
            "Master's Degree",
            "Doctorate / Professional",
            "Self-taught / Other"
        )

        val EXPERIENCE_OPTIONS = listOf(
            "First time",
            "Some experience",
            "Experienced"
        )
    }

    val displayGender: String
        get() = when {
            gender == "Self-describe" && customGender.isNotBlank() -> customGender
            gender.isNotBlank() -> gender
            else -> "Not specified"
        }
}
