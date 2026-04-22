package com.example.connectparbhsni;

import java.util.ArrayList;
import java.util.List;

public class SchoolCollegeDataProvider {
    private static List<SchoolCollegeModel> cachedData;

    public static List<SchoolCollegeModel> getSchoolCollegeData() {
        if (cachedData != null) return cachedData;

        cachedData = new ArrayList<>();

        // --- SCHOOLS (30) ---
        cachedData.add(new SchoolCollegeModel("Podar International School", "SCHOOL", "Vasmat Road, Parbhani", 19.259444, 76.785278, "Leading CBSE school with modern infrastructure and global teaching standards.", "02452-205111", "www.podareducation.org", "2010", true));
        cachedData.add(new SchoolCollegeModel("Kendriya Vidyalaya Parbhani", "SCHOOL", "VNMKV Campus, Parbhani", 19.267800, 76.771200, "Central government school providing standardized CBSE education.", "02452-223451", "parbhani.kvs.ac.in", "1992", true));
        cachedData.add(new SchoolCollegeModel("Jawahar Navodaya Vidyalaya", "SCHOOL", "Zari, Parbhani", 19.230556, 76.820556, "Residential school for talented rural children under Navodaya Vidyalaya Samiti.", "02452-220001", "navodaya.gov.in", "1986", true));
        cachedData.add(new SchoolCollegeModel("Advaita School Of Excellence", "SCHOOL", "Near Zilla Parishad, Parbhani", 19.274200, 76.783100, "Holistic education with focus on academic and personal excellence.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Hon Ratnakarrao Gutte International School", "SCHOOL", "Gangakhed Road, Parbhani", 19.278500, 76.794200, "Modern international school providing quality educational facilities.", "N/A", "N/A", "N/A", true));
        cachedData.add(new SchoolCollegeModel("NVS Marathwada High School", "SCHOOL", "Shivaji Nagar, Parbhani", 19.269200, 76.776500, "One of the prominent high schools in the Marathwada region.", "N/A", "N/A", "N/A", true));
        cachedData.add(new SchoolCollegeModel("Queen’s English School Pathri", "SCHOOL", "Pathri, Parbhani", 19.251000, 76.452000, "Leading English medium school in Pathri town.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Vedant Vidya Mandir Gangakhed", "SCHOOL", "Gangakhed, Parbhani", 18.966000, 76.751000, "Respected educational institution in Gangakhed.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Balvidhya Mandir High School", "SCHOOL", "Kalyan Nagar, Parbhani", 19.268000, 76.770000, "Focused on quality education and overall development since 1965.", "02452-225641", "bvmparbhani.com", "1965", true));
        cachedData.add(new SchoolCollegeModel("St Augustine English School", "SCHOOL", "Station Road, Parbhani", 19.264000, 76.781000, "Well-known convent school providing excellent primary and secondary education.", "02452-224151", "staugustine.ac.in", "1980", true));
        cachedData.add(new SchoolCollegeModel("Bharatiya Bal Vidya Mandir", "SCHOOL", "Nanalpeth, Parbhani", 19.270500, 76.772000, "Dedicated to providing value-based education to children.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Nutan Vidyalaya Parbhani", "SCHOOL", "Subhash Road, Parbhani", 19.265500, 76.774500, "A historic institution serving the educational needs of the city.", "N/A", "N/A", "1916", true));
        cachedData.add(new SchoolCollegeModel("Jijau Dnyantirth High School", "SCHOOL", "Basmath Road, Parbhani", 19.273000, 76.779000, "Focused on empowering students through knowledge.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Dr Zakir Hussain High School", "SCHOOL", "Eidgah Road, Parbhani", 19.261000, 76.771500, "Prominent school providing secondary education.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("National Urdu High School", "SCHOOL", "Old City, Parbhani", 19.260000, 76.773000, "A key institution for Urdu medium education in the region.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Sanskruti Vidyaniketan English School", "SCHOOL", "Kalyan Mandap Road, Parbhani", 19.274000, 76.782000, "Emphasizing cultural values along with modern education.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Oasis English School", "SCHOOL", "Deshmukh Road, Parbhani", 19.271500, 76.786000, "Providing a nurturing environment for early education.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("LKR Rodge Prince English School", "SCHOOL", "Shinde Nagar, Parbhani", 19.276000, 76.784000, "Dedicated to excellence in English medium schooling.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Al Falah International School", "SCHOOL", "Khadkali, Parbhani", 19.258500, 76.776500, "An international perspective on Islamic and modern education.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("ACME English School", "SCHOOL", "Dhangar Lane, Parbhani", 19.277000, 76.781500, "Committed to academic success and student growth.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Mamta High School", "SCHOOL", "Shivaji Nagar, Parbhani", 19.269500, 76.773500, "Serving the community with secondary education programs.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Raosaheb Jamkar Vidyalaya", "SCHOOL", "Zilla Parishad Area, Parbhani", 19.264500, 76.770500, "Focused on traditional education and holistic development.", "N/A", "N/A", "N/A", true));
        cachedData.add(new SchoolCollegeModel("Prabhavati Vidyalaya", "SCHOOL", "Market Area, Parbhani", 19.263500, 76.777500, "Known for its contribution to local primary education.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Swiss Academy School", "SCHOOL", "Basmath Road, Parbhani", 19.272500, 76.783500, "Modern teaching methodologies for the young learners.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Vision English School", "SCHOOL", "Jintur Road, Parbhani", 19.273500, 76.787500, "Clear vision for student success in a competitive world.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Varad Balak Mandir", "SCHOOL", "Station Road, Parbhani", 19.266500, 76.775500, "Foundation for early childhood education.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Devnandra High School", "SCHOOL", "Near Old Mondha, Parbhani", 19.267000, 76.778500, "Providing secondary level education to local students.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Faijane Haq Urdu High School", "SCHOOL", "Nanalpeth, Parbhani", 19.257500, 76.774000, "A dedicated Urdu medium high school.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Abdul Khalek Ansari Urdu High School", "SCHOOL", "Old City, Parbhani", 19.259500, 76.772500, "Institutional excellence in Urdu education.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Keshavraj Babasaheb Primary & Highschool", "SCHOOL", "Nanalpeth Area, Parbhani", 19.262500, 76.780500, "Respected primary and secondary school with long history.", "N/A", "N/A", "N/A", true));

        // --- COLLEGES (31) ---
        cachedData.add(new SchoolCollegeModel("Vasantrao Naik Marathwada Krishi Vidyapeeth", "COLLEGE", "Krishi Nagar, Parbhani", 19.266700, 76.772500, "One of the top agricultural universities in India, offering specialized research and degree programs.", "02452-223002", "vnmkv.ac.in", "1972", true));
        cachedData.add(new SchoolCollegeModel("Shri Shivaji College of Arts Commerce and Science", "COLLEGE", "Basmat Road, Parbhani", 19.261200, 76.782100, "Premier multi-disciplinary college known for academic excellence.", "02452-220731", "shrishivajicollege.org", "1961", true));
        cachedData.add(new SchoolCollegeModel("D S M Arts Commerce Science College", "COLLEGE", "Jintur Road, Parbhani", 19.278500, 76.775000, "Reputed institution for higher education in multiple streams.", "02452-221073", "dnyanopasak.org.in", "1984", true));
        cachedData.add(new SchoolCollegeModel("Late Nitin Arts and Science College Pathri", "COLLEGE", "Pathri, Parbhani", 19.255000, 76.455000, "Prominent college serving the educational needs of the Pathri region.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Nutan College Selu", "COLLEGE", "Selu, Parbhani", 19.456000, 76.452000, "Key higher education provider in Selu town.", "02451-223041", "nvsacs.com", "1968", true));
        cachedData.add(new SchoolCollegeModel("Shri Sant Janabai Arts Commerce Science College", "COLLEGE", "Gangakhed, Parbhani", 18.967000, 76.755000, "Serving the Gangakhed region with degree programs in various streams.", "N/A", "N/A", "1972", true));
        cachedData.add(new SchoolCollegeModel("Saraswati Dhanwantari Dental College", "COLLEGE", "Parbhani", 19.271000, 76.765000, "Specialized institution for dental science and research.", "N/A", "sddc.edu.in", "N/A", true));
        cachedData.add(new SchoolCollegeModel("P D Jain Homoeopathic Medical College", "COLLEGE", "Vakil Colony, Parbhani", 19.265000, 76.768000, "Leading medical college specializing in Homeopathic medicine.", "02452-221035", "pdjainhmc.org", "1915", true));
        cachedData.add(new SchoolCollegeModel("Government College of Veterinary and Animal Sciences", "COLLEGE", "Parbhani", 19.268500, 76.771500, "Dedicated to animal health and veterinary research.", "N/A", "mafsu.ac.in", "1972", true));
        cachedData.add(new SchoolCollegeModel("Rajiv Gandhi College of Agriculture and Food Technology", "COLLEGE", "Parbhani", 19.260500, 76.781500, "Focused on modern agricultural techniques and food processing.", "N/A", "rgcagri.com", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Shri Shivaji Institute of Engineering and Management Studies", "COLLEGE", "Parbhani", 19.258000, 76.786500, "Quality technical education in engineering and management.", "N/A", "ssiems.org.in", "2010", true));
        cachedData.add(new SchoolCollegeModel("Sitaramji Mundada Polytechnic College", "COLLEGE", "Parbhani", 19.275500, 76.789500, "Technical education through various diploma programs.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Shri Shivaji Law College", "COLLEGE", "Basmat Road, Parbhani", 19.261500, 76.782500, "Prestigious law institution offering LLB and LLM courses.", "02452-222461", "sslcparbhani.com", "1958", true));
        cachedData.add(new SchoolCollegeModel("Puranmal Lahoti Government Polytechnic", "COLLEGE", "Latur Road, Parbhani", 19.255500, 76.778500, "One of the oldest government polytechnic colleges in the region.", "N/A", "plgp.ac.in", "1958", true));
        cachedData.add(new SchoolCollegeModel("Government Polytechnic Jintur", "COLLEGE", "Jintur, Parbhani", 19.610000, 76.690000, "Government institution providing technical diploma courses.", "N/A", "gpjintur.org.in", "1983", true));
        cachedData.add(new SchoolCollegeModel("College of Agriculture Parbhani", "COLLEGE", "VNMKV Campus, Parbhani", 19.267200, 76.773000, "Constituent college of VNMKV offering agri-degree programs.", "N/A", "N/A", "1956", true));
        cachedData.add(new SchoolCollegeModel("College of Agricultural Engineering", "COLLEGE", "VNMKV Campus, Parbhani", 19.267800, 76.774000, "Specialized in agricultural machinery and tech engineering.", "N/A", "N/A", "N/A", true));
        cachedData.add(new SchoolCollegeModel("Kohinoor Technical Institute", "COLLEGE", "Parbhani", 19.263000, 76.770000, "Vocational and technical skill training provider.", "N/A", "kti.ac.in", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Paramanand College of Fire Engineering", "COLLEGE", "Parbhani", 19.270500, 76.780500, "Unique institution offering fire safety and engineering courses.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Shivaji Polytechnic Institute", "COLLEGE", "Parbhani", 19.262000, 76.783000, "Committed to technical education for local youth.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Marathwada Agriculture Training College", "COLLEGE", "Parbhani", 19.269000, 76.772500, "Providing practical training in modern agriculture.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Gangakhed Science College", "COLLEGE", "Gangakhed, Parbhani", 18.968000, 76.756000, "Focused on science education in Gangakhed.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Selu Arts Commerce College", "COLLEGE", "Selu, Parbhani", 19.457000, 76.453000, "Degree college serving Selu and surrounding areas.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Pathri Senior College", "COLLEGE", "Pathri, Parbhani", 19.256000, 76.456000, "Institutional higher education for Pathri community.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Marathwada Pharmacy College", "COLLEGE", "Parbhani", 19.272000, 76.785000, "Educational foundation for pharmacy professionals.", "N/A", "N/A", "N/A", true));
        cachedData.add(new SchoolCollegeModel("Agricultural Technology Institute", "COLLEGE", "Parbhani", 19.266000, 76.771000, "Focus on technological interventions in agriculture.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Engineering Skill Development Institute", "COLLEGE", "Parbhani", 19.259500, 76.787500, "Bridge between engineering degrees and industry skills.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Teacher Education College Parbhani", "COLLEGE", "Parbhani", 19.264000, 76.773000, "Preparing future educators through B.Ed and D.Ed programs.", "N/A", "N/A", "N/A", true));
        cachedData.add(new SchoolCollegeModel("Physical Education College Parbhani", "COLLEGE", "Parbhani", 19.265000, 76.774000, "Specialized in sports and physical education training.", "N/A", "N/A", "N/A", false));
        cachedData.add(new SchoolCollegeModel("Marathwada Nursing College", "COLLEGE", "Parbhani", 19.273000, 76.788000, "Providing professional nursing and healthcare training.", "N/A", "N/A", "N/A", true));
        cachedData.add(new SchoolCollegeModel("Yeshwant Collage Of IT", "COLLEGE", "Parbhani", 19.261000, 76.776000, "Institutional focus on Information Technology and computer science.", "N/A", "N/A", "N/A", false));

        return cachedData;
    }
}
