// ScheduleWithMedicine.kt
package com.example.medassist.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class ScheduleWithMedicine(
    @Embedded val scheduleEntry: ScheduleEntry,
    @Relation(
        parentColumn = "medicineId",
        entityColumn = "medicineId"
    )
    val medicine: Medicine?
)