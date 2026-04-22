package com.example.connectparbhsni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainDataProvider {

    private static List<TrainModel> cachedTrains;

    public static List<TrainModel> getTrainsForRoute(String from, String to) {
        List<TrainModel> allTrains = getTrains();
        List<TrainModel> filteredTrains = new ArrayList<>();

        if (from == null || to == null) return filteredTrains;

        for (TrainModel train : allTrains) {
            List<String> stations = train.getStationList();
            int fromIndex = -1;
            int toIndex = -1;

            for (int i = 0; i < stations.size(); i++) {
                if (stations.get(i).equalsIgnoreCase(from)) {
                    fromIndex = i;
                }
                if (stations.get(i).equalsIgnoreCase(to)) {
                    toIndex = i;
                }
            }

            if (fromIndex != -1 && toIndex != -1 && fromIndex < toIndex) {
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }

    public static List<TrainModel> getTrains() {
        if (cachedTrains != null) return cachedTrains;
        
        cachedTrains = new ArrayList<>();

        cachedTrains.add(new TrainModel("17064", "Ajanta Express", "Parbhani", "Manmad", "02:15", "10:30", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Lasur", "Rotegaon", "Nagarsol", "Manmad")));
        cachedTrains.add(new TrainModel("17057", "Devagiri Express", "Parbhani", "Mumbai CSMT", "07:35", "18:40", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Nasik Road", "Kalyan", "Thane", "Dadkar", "Mumbai CSMT")));
        cachedTrains.add(new TrainModel("17058", "Devagiri Express", "Parbhani", "Lingampalli", "21:00", "08:00", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Dharmabad", "Basar", "Nizamabad", "Kamareddi", "Secunderabad", "Lingampalli")));
        cachedTrains.add(new TrainModel("17687", "Marathwada Express", "Parbhani", "Manmad", "06:40", "12:30", Arrays.asList("Parbhani", "Manwath Road", "Selu", "Partur", "Jalna", "Aurangabad", "Lasur", "Manmad")));
        cachedTrains.add(new TrainModel("17688", "Marathwada Express", "Parbhani", "Dharmabad", "14:10", "20:00", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Umri", "Dharmabad")));
        cachedTrains.add(new TrainModel("12715", "Sachkhand Express", "Parbhani", "Nanded", "09:15", "10:55", Arrays.asList("Parbhani", "Purna", "Nanded")));
        cachedTrains.add(new TrainModel("12716", "Sachkhand Express", "Parbhani", "Delhi", "03:45", "18:00", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Bhusaval", "Bhopal", "Jhansi", "Gwalior", "Agra Cantt", "New Delhi")));
        cachedTrains.add(new TrainModel("17613", "Panvel Express", "Parbhani", "Panvel", "06:52", "13:10", Arrays.asList("Parbhani", "Parli Vaijnath", "Latur Road", "Latur", "Osmanabad", "Kurduvadi", "Pune", "Panvel")));
        cachedTrains.add(new TrainModel("17614", "Panvel Express", "Parbhani", "Nanded", "19:20", "05:25", Arrays.asList("Parbhani", "Purna", "Nanded")));
        cachedTrains.add(new TrainModel("11403", "Nagpur Kolhapur Express", "Parbhani", "Kolhapur", "00:15", "13:30", Arrays.asList("Parbhani", "Purna", "Hingoli", "Washim", "Akola", "Badnera", "Nagpur")));
        cachedTrains.add(new TrainModel("11001", "Nandigram Express", "Parbhani", "Mumbai CSMT", "03:25", "18:45", Arrays.asList("Parbhani", "Selu", "Partur", "Jalna", "Aurangabad", "Manmad", "Nasik Road", "Kalyan", "Thane", "Mumbai CSMT")));
        cachedTrains.add(new TrainModel("11002", "Nandigram Express", "Parbhani", "Balharshah", "17:55", "08:45", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Bhokar", "Kinwat", "Adilabad", "Balharshah")));
        cachedTrains.add(new TrainModel("17612", "Rajya Rani Express", "Parbhani", "Nanded", "05:47", "14:20", Arrays.asList("Parbhani", "Purna", "Nanded")));
        cachedTrains.add(new TrainModel("17611", "Rajya Rani Express", "Parbhani", "Mumbai CSMT", "23:00", "08:30", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Nasik Road", "Kalyan", "Thane", "Mumbai CSMT")));
        cachedTrains.add(new TrainModel("12071", "Jan Shatabdi Express", "Parbhani", "Hingoli", "06:15", "12:20", Arrays.asList("Parbhani", "Purna", "Basmat", "Hingoli")));
        cachedTrains.add(new TrainModel("12072", "Jan Shatabdi Express", "Parbhani", "Mumbai", "14:30", "20:45", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Nasik Road", "Kalyan", "Thane", "Mumbai")));
        cachedTrains.add(new TrainModel("20705", "Vande Bharat Express", "Parbhani", "Mumbai CSMT", "05:42", "12:30", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Nasik Road", "Thane", "Mumbai CSMT")));
        cachedTrains.add(new TrainModel("17618", "Tapovan Express", "Parbhani", "Mumbai", "11:15", "17:57", Arrays.asList("Parbhani", "Manwath Road", "Selu", "Partur", "Jalna", "Aurangabad", "Manmad", "Nasik Road", "Kalyan", "Thane", "Mumbai")));
        cachedTrains.add(new TrainModel("17205", "Shirdi Express", "Parbhani", "Sainagar Shirdi", "00:05", "09:30", Arrays.asList("Parbhani", "Selu", "Jalna", "Aurangabad", "Manmad", "Kopargaon", "Sainagar Shirdi")));
        cachedTrains.add(new TrainModel("17207", "Machilipatnam Express", "Parbhani", "Machilipatnam", "00:05", "17:35", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Nizamabad", "Secunderabad", "Warangal", "Vijayawada", "Machilipatnam")));
        cachedTrains.add(new TrainModel("17208", "Machilipatnam Express", "Parbhani", "Shirdi", "01:45", "09:10", Arrays.asList("Parbhani", "Selu", "Jalna", "Aurangabad", "Manmad", "Sainagar Shirdi")));
        cachedTrains.add(new TrainModel("17002", "Secunderabad Express", "Parbhani", "Secunderabad", "01:45", "09:10", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Nizamabad", "Kamareddi", "Secunderabad")));
        cachedTrains.add(new TrainModel("16593", "Bengaluru Express", "Parbhani", "Bengaluru", "20:28", "07:30", Arrays.asList("Parbhani", "Parli Vaijnath", "Latur Road", "Raichur", "Guntakal", "Dharmavaram", "Bengaluru")));
        cachedTrains.add(new TrainModel("16594", "Bengaluru Express", "Parbhani", "Nanded", "07:35", "21:10", Arrays.asList("Parbhani", "Purna", "Nanded")));
        cachedTrains.add(new TrainModel("16003", "Chennai Express", "Parbhani", "Chennai", "06:58", "23:30", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Nizamabad", "Secunderabad", "Guntur", "Nellore", "Chennai")));
        cachedTrains.add(new TrainModel("16004", "Chennai Express", "Parbhani", "Nagarsol", "17:58", "10:00", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Nagarsol")));
        cachedTrains.add(new TrainModel("17418", "Tirupati Express", "Parbhani", "Tirupati", "02:10", "11:30", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Nizamabad", "Secunderabad", "Guntakal", "Cuddapah", "Tirupati")));
        cachedTrains.add(new TrainModel("19302", "Indore Express", "Parbhani", "Indore", "15:45", "07:15", Arrays.asList("Parbhani", "Purna", "Hingoli", "Washim", "Akola", "Khandwa", "Ujjain", "Indore")));
        cachedTrains.add(new TrainModel("57515", "Passenger", "Parbhani", "Nanded", "01:15", "08:45", Arrays.asList("Parbhani", "Pingli", "Mirkhal", "Purna", "Ardhapur", "Nanded")));
        cachedTrains.add(new TrainModel("57521", "Passenger", "Parbhani", "Purna", "22:10", "23:40", Arrays.asList("Parbhani", "Pingli", "Mirkhal", "Purna")));
        cachedTrains.add(new TrainModel("57522", "Passenger", "Parbhani", "Parli", "17:05", "18:35", Arrays.asList("Parbhani", "Singnapur", "Dhoki", "Parli")));
        cachedTrains.add(new TrainModel("57539", "Passenger", "Parbhani", "Parli Vaijnath", "20:30", "03:15", Arrays.asList("Parbhani", "Gangakhed", "Parli Vaijnath")));
        cachedTrains.add(new TrainModel("77615", "Local Train", "Parbhani", "Adilabad", "06:00", "09:20", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Bhokar", "Adilabad")));
        cachedTrains.add(new TrainModel("07665", "Special", "Parbhani", "Nanded", "09:40", "11:25", Arrays.asList("Parbhani", "Purna", "Nanded")));
        cachedTrains.add(new TrainModel("07663", "Special", "Parbhani", "Jalna", "07:10", "08:20", Arrays.asList("Parbhani", "Selu", "Partur", "Jalna")));
        cachedTrains.add(new TrainModel("11410", "DMU", "Parbhani", "Pune", "03:50", "14:30", Arrays.asList("Parbhani", "Parli", "Latur Road", "Osmanabad", "Kurduvadi", "Daund", "Pune")));
        cachedTrains.add(new TrainModel("11409", "DMU", "Parbhani", "Nizamabad", "05:10", "16:00", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Dharmabad", "Basar", "Nizamabad")));
        cachedTrains.add(new TrainModel("11045", "Kolhapur Express", "Parbhani", "Kolhapur", "18:12", "08:45", Arrays.asList("Parbhani", "Parli", "Latur Road", "Latur", "Osmanabad", "Kurduvadi", "Miraj", "Kolhapur")));
        cachedTrains.add(new TrainModel("11046", "Kolhapur Express", "Parbhani", "Dhanbad", "22:50", "12:30", Arrays.asList("Parbhani", "Purna", "Hingoli", "Washim", "Akola", "Nagpur", "Jabalpur", "Gaya", "Dhanbad")));
        cachedTrains.add(new TrainModel("12788", "SF Express", "Parbhani", "Narasapur", "16:32", "09:20", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Nizamabad", "Secunderabad", "Guntur", "Vijayawada", "Narasapur")));
        cachedTrains.add(new TrainModel("17621", "Tirupati Express", "Parbhani", "Tirupati", "00:05", "16:00", Arrays.asList("Parbhani", "Parli", "Latur Road", "Raichur", "Guntakal", "Tirupati")));
        cachedTrains.add(new TrainModel("17648", "Hyderabad Express", "Parbhani", "Hyderabad", "08:10", "14:40", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Dharmabad", "Nizamabad", "Hyderabad")));
        cachedTrains.add(new TrainModel("07417", "Special Express", "Parbhani", "Shirdi", "07:30", "11:55", Arrays.asList("Parbhani", "Selu", "Jalna", "Aurangabad", "Nagarsol", "Sainagar Shirdi")));
        cachedTrains.add(new TrainModel("07418", "Special Express", "Parbhani", "Kacheguda", "22:00", "04:00", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Nizamabad", "Kacheguda")));
        cachedTrains.add(new TrainModel("07619", "Special", "Parbhani", "Pune", "23:00", "13:15", Arrays.asList("Parbhani", "Parli", "Latur Road", "Latur", "Osmanabad", "Kurduvadi", "Daund", "Pune")));
        cachedTrains.add(new TrainModel("01106", "Special", "Parbhani", "LTT Mumbai", "00:15", "10:30", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Nasik Road", "LTT")));
        cachedTrains.add(new TrainModel("07625", "Special", "Parbhani", "Panvel", "00:15", "10:20", Arrays.asList("Parbhani", "Parli", "Latur Road", "Kurduvadi", "Pune", "Panvel")));
        cachedTrains.add(new TrainModel("17640", "Express", "Parbhani", "Aurangabad", "08:45", "12:20", Arrays.asList("Parbhani", "Selu", "Partur", "Jalna", "Aurangabad")));
        cachedTrains.add(new TrainModel("17641", "Express", "Parbhani", "Jalna", "12:15", "14:00", Arrays.asList("Parbhani", "Manwath Road", "Selu", "Partur", "Jalna")));
        cachedTrains.add(new TrainModel("17642", "Express", "Parbhani", "Akola", "14:10", "18:30", Arrays.asList("Parbhani", "Purna", "Basmat", "Hingoli", "Washim", "Akola")));
        cachedTrains.add(new TrainModel("12729", "Pune SF Express", "Parbhani", "Pune", "21:30", "08:15", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Kopargaon", "Ahmednagar", "Pune")));
        cachedTrains.add(new TrainModel("12730", "Nanded SF Express", "Parbhani", "Nanded", "08:45", "10:15", Arrays.asList("Parbhani", "Purna", "Nanded")));
        cachedTrains.add(new TrainModel("17639", "Intercity Express", "Parbhani", "Nagpur", "13:20", "22:45", Arrays.asList("Parbhani", "Purna", "Hingoli", "Washim", "Akola", "Badnera", "Wardha", "Nagpur")));
        cachedTrains.add(new TrainModel("11401", "Nandigram Express", "Parbhani", "Nagpur", "23:45", "10:20", Arrays.asList("Parbhani", "Purna", "Hingoli", "Washim", "Akola", "Badnera", "Wardha", "Nagpur")));
        cachedTrains.add(new TrainModel("12767", "Humsafar Express", "Parbhani", "Kolkata Santragachi", "17:15", "19:20", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Bilaspur", "Jharsuguda", "Rourkela", "Tatanagar", "Santragachi")));
        cachedTrains.add(new TrainModel("12768", "Humsafar Express", "Parbhani", "Hazrat Nizamuddin", "14:10", "18:45", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Bhusaval", "Itarsi", "Bhopal", "Jhansi", "Agra", "Hazrat Nizamuddin")));
        cachedTrains.add(new TrainModel("17609", "Patna Express", "Parbhani", "Patna", "21:20", "07:00", Arrays.asList("Parbhani", "Purna", "Hingoli", "Washim", "Akola", "Khandwa", "Itarsi", "Jabalpur", "Katni", "Satna", "Prayagraj Chheoki", "Patna")));
        cachedTrains.add(new TrainModel("17610", "Purna Patna Express", "Parbhani", "Purna", "14:35", "15:20", Arrays.asList("Parbhani", "Purna")));
        cachedTrains.add(new TrainModel("17623", "HSR TPJ Express", "Parbhani", "Tiruchchirappalli", "03:45", "15:30", Arrays.asList("Parbhani", "Parli", "Latur Road", "Raichur", "Guntakal", "Dharmavaram", "Vellore", "Tiruchchirappalli")));
        cachedTrains.add(new TrainModel("17624", "TPJ HSR Express", "Parbhani", "Sri Ganganagar", "18:20", "09:45", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Bhusaval", "Ahmedabad", "Jodhpur", "Bikaner", "Sri Ganganagar")));
        cachedTrains.add(new TrainModel("17019", "JP HYB Express", "Parbhani", "Hyderabad", "01:20", "07:30", Arrays.asList("Parbhani", "Purna", "Nanded", "Mudkhed", "Dharmabad", "Nizamabad", "Secunderabad", "Hyderabad")));
        cachedTrains.add(new TrainModel("17020", "HYB JP Express", "Parbhani", "Jaipur", "22:15", "05:25", Arrays.asList("Parbhani", "Jalna", "Aurangabad", "Manmad", "Bhusaval", "Khandwa", "Itarsi", "Bhopal", "Ujjain", "Ratlam", "Ajmer", "Jaipur")));

        return cachedTrains;
    }
}
