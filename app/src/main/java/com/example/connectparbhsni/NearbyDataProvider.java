package com.example.connectparbhsni;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NearbyDataProvider {

    private static List<PlaceModel> cachedPlaces;

    public static List<PlaceModel> getPlaces() {
        if (cachedPlaces != null) return cachedPlaces;

        cachedPlaces = new ArrayList<>();

        // 1️⃣ HOSPITALS
        cachedPlaces.add(new PlaceModel("District Civil Hospital Parbhani", "HOSPITAL", "Subhash Road, Parbhani", "02452 223344", "Open 24h", "0.5 km", 19.266580, 76.776320));
        cachedPlaces.add(new PlaceModel("Chirayu Hospital", "HOSPITAL", "Nanded Road, Parbhani", "02452 225566", "Open 24h", "1.1 km", 19.271440, 76.781250));
        cachedPlaces.add(new PlaceModel("Dr. Prafulla Patil Multispeciality Hospital", "HOSPITAL", "Basmath Road, Parbhani", "02452 221122", "Open 24h", "1.4 km", 19.268750, 76.779480));
        cachedPlaces.add(new PlaceModel("Jethlia Hospital", "HOSPITAL", "Station Road, Parbhani", "02452 229988", "Open 24h", "0.8 km", 19.265220, 76.772510));
        cachedPlaces.add(new PlaceModel("Parbhani ICU & Trauma Care Center", "HOSPITAL", "Shivaji Nagar, Parbhani", "02452 230011", "Open 24h", "1.2 km", 19.267820, 76.775550));
        cachedPlaces.add(new PlaceModel("Deshmukh Hospital", "HOSPITAL", "Kalyan Mandap Road, Parbhani", "02452 224455", "Open 24h", "0.9 km", 19.268110, 76.774180));
        cachedPlaces.add(new PlaceModel("Ganesh Netralaya", "HOSPITAL", "Basmath Road, Parbhani", "02452 227788", "9:00 AM - 8:00 PM", "1.5 km", 19.273180, 76.783450));
        cachedPlaces.add(new PlaceModel("Yashodeep Multispeciality Hospital", "HOSPITAL", "Nanded Naka, Parbhani", "02452 226677", "Open 24h", "2.2 km", 19.261450, 76.790520));
        cachedPlaces.add(new PlaceModel("Lotus Hospital", "HOSPITAL", "Basmath Road, Parbhani", "02452 225544", "Open 24h", "1.3 km", 19.270180, 76.780850));
        cachedPlaces.add(new PlaceModel("Lifeline Multispeciality Hospital", "HOSPITAL", "Gangakhed Road, Parbhani", "02452 223399", "Open 24h", "2.8 km", 19.252450, 76.762480));

        // 2️⃣ ATMs
        cachedPlaces.add(new PlaceModel("SBI ATM Jorawar Singh Gate", "ATM", "Jorawar Singh Gate, Parbhani", "N/A", "Open 24h", "0.6 km", 19.267450, 76.774180));
        cachedPlaces.add(new PlaceModel("SBI ATM Basmat Road", "ATM", "Basmat Road, Parbhani", "N/A", "Open 24h", "1.6 km", 19.271920, 76.782850));
        cachedPlaces.add(new PlaceModel("ICICI ATM Bus Stand Road", "ATM", "Bus Stand Road, Parbhani", "N/A", "Open 24h", "0.7 km", 19.265480, 76.772750));
        cachedPlaces.add(new PlaceModel("Canara Bank ATM New Mondha", "ATM", "New Mondha, Parbhani", "N/A", "Open 24h", "1.9 km", 19.277850, 76.787820));
        cachedPlaces.add(new PlaceModel("HDFC ATM Shivaji Nagar", "ATM", "Shivaji Nagar, Parbhani", "N/A", "Open 24h", "1.1 km", 19.269150, 76.776480));
        cachedPlaces.add(new PlaceModel("Bank of India ATM Station Road", "ATM", "Station Road, Parbhani", "N/A", "Open 24h", "0.5 km", 19.266150, 76.773450));
        cachedPlaces.add(new PlaceModel("Axis Bank ATM Railway Station Area", "ATM", "Station Area, Parbhani", "N/A", "Open 24h", "0.4 km", 19.264420, 76.771480));
        cachedPlaces.add(new PlaceModel("Union Bank ATM Pathri Road", "ATM", "Pathri Road, Parbhani", "N/A", "Open 24h", "2.4 km", 19.259850, 76.754850));
        cachedPlaces.add(new PlaceModel("Indian Bank ATM Main Market", "ATM", "Main Market, Parbhani", "N/A", "Open 24h", "0.8 km", 19.268150, 76.774980));
        cachedPlaces.add(new PlaceModel("IDBI ATM Bus Stand Area", "ATM", "Bus Stand, Parbhani", "N/A", "Open 24h", "0.7 km", 19.265150, 76.772450));

        // 3️⃣ BANKS
        cachedPlaces.add(new PlaceModel("State Bank of India Main Branch", "BANK", "Main Branch, Parbhani", "02452 220011", "10:00 AM - 4:00 PM", "0.6 km", 19.267150, 76.774050));
        cachedPlaces.add(new PlaceModel("Bank of Maharashtra Parbhani", "BANK", "Station Road, Parbhani", "02452 220022", "10:00 AM - 4:00 PM", "0.5 km", 19.266750, 76.773750));
        cachedPlaces.add(new PlaceModel("HDFC Bank Parbhani", "BANK", "Shivaji Nagar, Parbhani", "02452 220033", "10:00 AM - 4:00 PM", "1.2 km", 19.269450, 76.776750));
        cachedPlaces.add(new PlaceModel("ICICI Bank Parbhani", "BANK", "Main Road, Parbhani", "02452 220044", "10:00 AM - 4:00 PM", "0.8 km", 19.268450, 76.775150));
        cachedPlaces.add(new PlaceModel("Axis Bank Parbhani", "BANK", "Basmath Road, Parbhani", "02452 220055", "10:00 AM - 4:00 PM", "1.4 km", 19.271450, 76.781450));
        cachedPlaces.add(new PlaceModel("Union Bank of India", "BANK", "Pathri Road, Parbhani", "02452 220066", "10:00 AM - 4:00 PM", "2.5 km", 19.260450, 76.755550));
        cachedPlaces.add(new PlaceModel("Canara Bank", "BANK", "New Mondha, Parbhani", "02452 220077", "10:00 AM - 4:00 PM", "2.0 km", 19.278450, 76.788450));
        cachedPlaces.add(new PlaceModel("Bank of Baroda", "BANK", "Gandhi Park, Parbhani", "02452 220088", "10:00 AM - 4:00 PM", "1.0 km", 19.269950, 76.775750));
        cachedPlaces.add(new PlaceModel("Central Bank of India", "BANK", "Subhash Road, Parbhani", "02452 220099", "10:00 AM - 4:00 PM", "0.4 km", 19.267750, 76.774550));
        cachedPlaces.add(new PlaceModel("Indian Overseas Bank", "BANK", "Station Road, Parbhani", "02452 220100", "10:00 AM - 4:00 PM", "0.6 km", 19.265750, 76.773150));

        // 4️⃣ POLICE STATIONS
        cachedPlaces.add(new PlaceModel("Parbhani City Police Station", "POLICE", "City Area, Parbhani", "02452 220033", "Open 24h", "0.9 km", 19.268750, 76.775750));
        cachedPlaces.add(new PlaceModel("Nanalpeth Police Station", "POLICE", "Nanalpeth, Parbhani", "02452 220044", "Open 24h", "1.1 km", 19.272450, 76.778450));
        cachedPlaces.add(new PlaceModel("MIDC Police Station", "POLICE", "MIDC Area, Parbhani", "02452 220055", "Open 24h", "3.5 km", 19.294950, 76.794950));
        cachedPlaces.add(new PlaceModel("Railway Police Station", "POLICE", "Railway Station, Parbhani", "02452 220066", "Open 24h", "0.4 km", 19.264750, 76.771750));
        cachedPlaces.add(new PlaceModel("Shivaji Nagar Police Station", "POLICE", "Shivaji Nagar, Parbhani", "02452 220077", "Open 24h", "1.3 km", 19.269750, 76.776950));
        cachedPlaces.add(new PlaceModel("Jintur Road Police Station", "POLICE", "Jintur Road, Parbhani", "02452 220088", "Open 24h", "2.6 km", 19.285950, 76.770950));

        // 5️⃣ PETROL PUMPS
        cachedPlaces.add(new PlaceModel("Indian Oil Basmat Road", "PETROL", "Basmat Road, Parbhani", "N/A", "Open 24h", "1.5 km", 19.273450, 76.783950));
        cachedPlaces.add(new PlaceModel("HP Petrol Pump Jintur Road", "PETROL", "Jintur Road, Parbhani", "N/A", "Open 24h", "2.3 km", 19.281950, 76.771450));
        cachedPlaces.add(new PlaceModel("Bharat Petroleum Pathri Road", "PETROL", "Pathri Road, Parbhani", "N/A", "Open 24h", "2.6 km", 19.260950, 76.753950));
        cachedPlaces.add(new PlaceModel("Reliance Petrol Pump MIDC", "PETROL", "MIDC, Parbhani", "N/A", "Open 24h", "3.8 km", 19.299950, 76.789950));
        cachedPlaces.add(new PlaceModel("Nayara Fuel Station Highway", "PETROL", "NH 61, Parbhani", "N/A", "Open 24h", "4.5 km", 19.309950, 76.799950));
        cachedPlaces.add(new PlaceModel("HP Petrol Pump Station Road", "PETROL", "Station Road, Parbhani", "N/A", "Open 24h", "0.7 km", 19.265750, 76.772750));
        cachedPlaces.add(new PlaceModel("Indian Oil Manwath Road", "PETROL", "Manwath Road, Parbhani", "N/A", "Open 24h", "5.2 km", 19.239950, 76.739950));
        cachedPlaces.add(new PlaceModel("BPCL Bus Stand Area", "PETROL", "Bus Stand, Parbhani", "N/A", "Open 24h", "0.8 km", 19.266150, 76.773150));
        cachedPlaces.add(new PlaceModel("IOCL Gangakhed Road", "PETROL", "Gangakhed Road, Parbhani", "N/A", "Open 24h", "3.2 km", 19.247950, 76.757950));
        cachedPlaces.add(new PlaceModel("HP Petrol Pump Shivaji Nagar", "PETROL", "Shivaji Nagar, Parbhani", "N/A", "Open 24h", "1.4 km", 19.270450, 76.777450));

        // 6️⃣ HOTELS & RESTAURANTS
        cachedPlaces.add(new PlaceModel("AZMAT HOTEL", "HOTEL", "City Area, Parbhani", "N/A", "9:00 AM - 11:00 PM", "1.0 km", 19.270950, 76.775950));
        cachedPlaces.add(new PlaceModel("MADANI HOTEL", "HOTEL", "Market Area, Parbhani", "N/A", "8:00 AM - 11:00 PM", "0.9 km", 19.268950, 76.774950));
        cachedPlaces.add(new PlaceModel("SAWERA HOTEL", "HOTEL", "Bus Stand Area, Parbhani", "N/A", "7:00 AM - 11:00 PM", "0.8 km", 19.266450, 76.773450));
        cachedPlaces.add(new PlaceModel("ZAMZAM HOTEL", "HOTEL", "Station Road, Parbhani", "N/A", "9:00 AM - 11:30 PM", "0.6 km", 19.265450, 76.772450));
        cachedPlaces.add(new PlaceModel("KINGS ARABIAN", "HOTEL", "Shivaji Nagar, Parbhani", "N/A", "12:00 PM - 11:00 PM", "1.5 km", 19.271950, 76.777950));
        cachedPlaces.add(new PlaceModel("RASTA CAFE", "HOTEL", "Basmath Road, Parbhani", "N/A", "11:00 AM - 11:00 PM", "1.8 km", 19.274450, 76.782450));
        cachedPlaces.add(new PlaceModel("KHAN MANDI HOTEL AND RESTORENT", "HOTEL", "Nanded Road, Parbhani", "N/A", "12:00 PM - 12:00 AM", "2.1 km", 19.275950, 76.784950));
        cachedPlaces.add(new PlaceModel("Hyderabad Biryani House", "HOTEL", "Station Road, Parbhani", "N/A", "11:00 AM - 11:00 PM", "0.7 km", 19.265950, 76.772950));
        cachedPlaces.add(new PlaceModel("GREEN LEAF", "HOTEL", "Shivaji Nagar, Parbhani", "N/A", "10:00 AM - 11:00 PM", "1.4 km", 19.269950, 76.777150));
        cachedPlaces.add(new PlaceModel("SAMA PALCE HOTGEL AND RESTORENT", "HOTEL", "Basmath Road, Parbhani", "N/A", "Open 24h", "2.0 km", 19.275450, 76.784450));

        return cachedPlaces;
    }

    public static List<PlaceModel> getHotelPlaces() {
        return getPlaces().stream()
                .filter(p -> p.getCategory().equals("HOTEL"))
                .collect(Collectors.toList());
    }
}
