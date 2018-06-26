package leetcode_ood;

import java.sql.Time;
import java.util.Date;
import java.util.List;

enum RoomStatus {
    EMPTY,
    NOT_EMPTY
    }

enum RoomType{
    SINGLE,
    DOUBLE,
    TRIPLE;
}

enum PaymentStatus {
    PAID,
    UNPAID;
}

class User{
    int userId;
    String name;
    Date dateOfBirth;
    String mobNo;
    String emailId;
    String sex;
}

// For the room in any hotel
class Room{

    int roomId;
    int hotelId;
    RoomType roomType;
    RoomStatus roomStatus;
}

class Hotel{

    int hotelId;
    String hotelName;
    Adress adress;
    List<Room> rooms; // hotel contains the list of rooms
    float rating;
    Facilities facilities;
}

// a new booking is created for each booking done by any user
class Booking{
    int bookingId;
    int userId;
    int hotelId;
    List<Room> bookedRooms;
    int amount;
    PaymentStatus status_of_payment;
    Time bookingTime;
    Duration duration;
}

class Adress{

    String city;
    String pinCode;
    String streetNo;
    String landmark;
}

class Duration{
    Time from;
    Time to;
}

class Facilities{
    boolean provides_lift;
    boolean provides_power_backup;
    boolean provides_hot_water;
    boolean provides_breakfast_free;
}
