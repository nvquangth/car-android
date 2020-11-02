package com.bt.car.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Car(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "objectId")
    val objectId: String? = null,

    @ColumnInfo(name = "id_trim")
    val trimId: String? = null,

    @ColumnInfo(name = "Make")
    val make: String? = null,

    @ColumnInfo(name = "Model")
    val model: String? = null,

    @ColumnInfo(name = "Generation")
    val generation: String? = null,

    @ColumnInfo(name = "Year_from_Generation")
    val yearFromGeneration: String? = null,

    @ColumnInfo(name = "Year_to_Generation")
    val yearToGeneration: String? = null,

    @ColumnInfo(name = "Serie")
    val serie: String? = null,

    @ColumnInfo(name = "Trim")
    val trim: String? = null,

    @ColumnInfo(name = "Body_type")
    val bodyType: String? = null,

    @ColumnInfo(name = "Number_of_seater")
    val numberOfSeater: String? = null,

    @ColumnInfo(name = "Length_mm")
    val length: String? = null,

    @ColumnInfo(name = "Width_mm")
    val width: String? = null,

    @ColumnInfo(name = "Height_mm")
    val height: String? = null,

    @ColumnInfo(name = "Wheelbase_mm")
    val wheelBase: String? = null,

    @ColumnInfo(name = "Front_track_mm")
    val frontTrack: String? = null,

    @ColumnInfo(name = "Rear_track_mm")
    val rearTrack: String? = null,

    @ColumnInfo(name = "Curb_weight_kg")
    val curbWeight: String? = null,

    @ColumnInfo(name = "Ground_clearance_mm")
    val groundClearance: String? = null,

    @ColumnInfo(name = "Max_trunk_capacity_litre")
    val maxTrunkCapacityLitre: String? = null,

    @ColumnInfo(name = "Min_trunk_capacity_litre")
    val minTrunkCapacityLitre: String? = null,

    @ColumnInfo(name = "Injection_type")
    val injectionType: String? = null,

    @ColumnInfo(name = "Engine_type")
    val engineType: String? = null,

    @ColumnInfo(name = "Capacity_cm3")
    val capacity: String? = null,

    @ColumnInfo(name = "Engine_power_hp")
    val enginePowerHp: String? = null,

    @ColumnInfo(name = "Max_power_at_RPM")
    val maxPowerAtRPM: String? = null,

    @ColumnInfo(name = "Maximum_torque")
    val maximumTorque: String? = null,

    @ColumnInfo(name = "Cylinder_layout")
    val cylinderLayout: String? = null,

    @ColumnInfo(name = "Number_of_cylinders")
    val numberOfCylinders: String? = null,

    @ColumnInfo(name = "Cylinder_bore")
    val cylinderBore: String? = null,

    @ColumnInfo(name = "Valves_per_cylinder")
    val valvesPerCylinder: String? = null,

    @ColumnInfo(name = "Stroke_cycle_mm")
    val strokeCycle: String? = null,

    @ColumnInfo(name = "Boost_type")
    val boostType: String? = null,

    @ColumnInfo(name = "Turnover_of_maximum_torque")
    val turnoverOfMaximumTorque: String? = null,

    @ColumnInfo(name = "Gearbox_type")
    val gearboxType: String? = null,

    @ColumnInfo(name = "Number_of_gear")
    val numberOfGear: String? = null,

    @ColumnInfo(name = "Drive_wheels")
    val driveWheels: String? = null,

    @ColumnInfo(name = "Fuel")
    val fuel: String? = null,

    @ColumnInfo(name = "City_driving_fuel_consumption_per")
    val cityDrivingFuelConsumptionPer: String? = null,

    @ColumnInfo(name = "Highway_driving_fuel_consumption")
    val highwayDrivingFuelConsumption: String? = null,

    @ColumnInfo(name = "Max_speed")
    val maxSpeed: String? = null,

    @ColumnInfo(name = "Acceleration")
    val acceleration: String? = null,

    @ColumnInfo(name = "Cruising_range")
    val cruisingRange: String? = null,

    @ColumnInfo(name = "Fuel_tank_capacity")
    val fuelTankCapacity: String? = null,

    @ColumnInfo(name = "Front_brakes")
    val frontBrakes: String? = null,

    @ColumnInfo(name = "Front_suspension")
    val frontSuspension: String? = null,

    @ColumnInfo(name = "Back_suspension")
    val backSuspension: String? = null,

    @ColumnInfo(name = "Rear_brakes")
    val rearBrakes: String? = null

) : Parcelable
