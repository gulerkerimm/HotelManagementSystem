package com.tpe.service;

import com.tpe.domain.Address;
import com.tpe.domain.Guest;
import com.tpe.exceptions.GuestNotFoundException;
import com.tpe.repository.GuestRepository;

import java.util.Scanner;

public class GuestService {

    private Scanner scanner=new Scanner(System.in);

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    //9-b
    public void saveGuest() {
        Guest guest=new Guest();
        System.out.println("Enter guest name : ");
        guest.setName(scanner.nextLine());

        Address address=new Address();
        System.out.println("Enter street : ");
        address.setStreet(scanner.nextLine());

        System.out.println("Enter city : ");
        address.setCity(scanner.nextLine());

        System.out.println("Enter country : ");
        address.setCountry(scanner.nextLine());

        System.out.println("Enter zipcode : ");
        address.setZipcode(scanner.nextLine());

        guest.setAddress(address);

        guestRepository.save(guest);
        System.out.println("Guest is saved successfully....");
    }

    //ödev2:b
    public Guest findGuestById(Long guestId) {
        try {
            Guest foundGuest=guestRepository.findById(guestId);
            if (foundGuest!=null){
                System.out.println("*-----------------------------------*");
                System.out.println(foundGuest);
                System.out.println("*-----------------------------------*");
                return foundGuest;
            }else {
                throw new GuestNotFoundException("Guest not found by ID:"+guestId);
            }
        }catch (GuestNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}