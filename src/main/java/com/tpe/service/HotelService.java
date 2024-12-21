package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.repository.Hotelrepository;

import java.util.Scanner;

public class HotelService {

    private Scanner scanner = new Scanner(System.in);

    private final Hotelrepository hotelrepository;

    public HotelService(Hotelrepository hotelrepository) {
        this.hotelrepository = hotelrepository;
    }

    //1-c:save hotel

    public void saveHotel() {

        Hotel hotel = new Hotel();

        System.out.println("Enter hotel ID: ");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter hotel name: ");
        hotel.setName(scanner.nextLine());

        System.out.println("Enter hotel location: ");
        hotel.setLocation(scanner.nextLine());


        hotelrepository.save(hotel);

        System.out.println("Hotel is saved successfully. Hotel ID : " + hotel.getId());


    }
}