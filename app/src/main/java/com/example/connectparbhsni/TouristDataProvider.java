package com.example.connectparbhsni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TouristDataProvider {
    private static List<TouristPlaceModel> cachedPlaces;

    public static List<TouristPlaceModel> getTouristPlaces() {
        if (cachedPlaces != null) return cachedPlaces;

        cachedPlaces = new ArrayList<>();
        
        // --- RELIGIOUS ---

        // 1️⃣ Hazrat Turabul Haq Dargah (Parbhani)
        cachedPlaces.add(new TouristPlaceModel(
            "Hazrat Turabul Haq Dargah (Parbhani)",
            "One of the most famous Sufi religious sites in Parbhani, visited by devotees of different faiths.",
            "Hazrat Turabul Haq Dargah is one of the most spiritually significant religious sites in Parbhani district. The shrine is dedicated to a respected Sufi saint who played an important role in spreading messages of peace, unity, and devotion among people. Over the years, the dargah has become a center of faith not only for the Muslim community but also for people from various religious backgrounds who visit to seek blessings and spiritual comfort.\n\nHistorically, the shrine reflects the deep-rooted influence of Sufism in the Deccan region. Sufi saints were known for their inclusive teachings and emphasis on compassion and humanity. The architecture of the dargah showcases traditional Indo-Islamic design elements, including a domed structure and detailed decorative patterns. The calm surroundings and spiritual atmosphere make it an important landmark in the cultural fabric of Parbhani.\n\nOne of the most significant events held here is the annual Urs festival, which commemorates the saint’s spiritual legacy. During this time, thousands of devotees gather to offer prayers, participate in religious recitations, and engage in charitable activities. The event strengthens communal harmony and represents the shared heritage of the region.\n\nToday, Hazrat Turabul Haq Dargah stands not only as a place of worship but also as a symbol of unity and cultural integration. It continues to attract pilgrims, historians, and tourists who are interested in understanding the religious and historical importance of Parbhani. The shrine plays a major role in religious tourism within the district.",
            "Hazrat Turabul Haq Dargah, Parbhani",
            19.2660,
            76.7830,
            Arrays.asList(
                R.drawable.turabul_haq_a,
                R.drawable.turabulh_aq_b,
                R.drawable.turabul_haq_c
            ),
            "RELIGIOUS"
        ));

        // 2️⃣ Aundha Nagnath Jyotirlinga Temple (Also fits Religious)
        cachedPlaces.add(new TouristPlaceModel(
            "Aundha Nagnath Jyotirlinga Temple",
            "Ancient Shiva temple and one of the twelve Jyotirlingas, known for deep historical and religious importance.",
            "Aundha Nagnath Temple is one of the most ancient and sacred temples dedicated to Lord Shiva and is considered among the twelve Jyotirlingas in Hindu tradition. The temple holds immense religious importance and attracts devotees from across India who come to seek blessings and experience its spiritual atmosphere.\n\nThe temple’s origin is connected with various mythological stories described in Hindu scriptures, and it is believed to date back several centuries. The structure reflects traditional Hemadpanthi architectural style, characterized by strong stone construction and intricate carvings that highlight ancient craftsmanship.\n\nHistorically, the temple has served as an important center of pilgrimage and cultural gatherings. Major festivals such as Maha Shivaratri bring large numbers of devotees who participate in rituals, prayers, and celebrations. The temple premises offer a calm environment that enhances the spiritual experience.\n\nToday, Aundha Nagnath remains a major religious destination and contributes significantly to religious tourism in the region. It represents the deep historical roots of Hindu spirituality in Maharashtra.",
            "Aundha Nagnath Temple",
            19.5400,
            77.0500,
            Arrays.asList(
                R.drawable.aa,
                R.drawable.bb,
                R.drawable.cc
            ),
            "RELIGIOUS"
        ));

        // 3️⃣ Shree Siddheshwar Temple (Parbhani region)
        cachedPlaces.add(new TouristPlaceModel(
            "Shree Siddheshwar Temple (Parbhani region)",
            "A peaceful temple dedicated to Lord Shiva, known among locals for spiritual gatherings.",
            "Shree Siddheshwar Temple is a peaceful religious site dedicated to Lord Shiva and is well known among local communities for its spiritual atmosphere. The temple serves as a gathering place where devotees come regularly for prayer, meditation, and participation in traditional rituals.\n\nHistorically, the temple reflects local religious traditions and the devotion of communities that have maintained the shrine for generations. Its simple yet meaningful architecture symbolizes traditional temple design found in rural and semi-urban areas of Maharashtra.\n\nFestivals and religious ceremonies play an important role in the temple’s cultural identity. Devotees often visit during special occasions to perform rituals and celebrate spiritual events, strengthening the bond between local culture and religious practices.\n\nToday, the temple continues to be a place where people seek inner peace and spiritual connection, making it an important religious landmark in the Parbhani region.",
            "Siddheshwar Temple, Parbhani",
            19.2635,
            76.7900,
            Arrays.asList(
                R.drawable.aaa,
                R.drawable.bbb,
                R.drawable.ccc
            ),
            "RELIGIOUS"
        ));

        // 4️⃣ Jintur Jain Temple (Also fits Religious)
        cachedPlaces.add(new TouristPlaceModel(
            "Jintur Jain Temple",
            "Historic Jain religious site reflecting ancient Jain architecture and spiritual heritage.",
            "The Jain Temple located in Jintur is an important religious and historical site representing the long-standing presence of Jainism in the region. Known for its serene environment and elegant structure, the temple attracts both devotees and visitors interested in historical architecture.\n\nJain temples are traditionally built with attention to detail and spiritual symbolism, and this temple reflects those values through its design and peaceful surroundings. The temple promotes core Jain principles such as non-violence, discipline, and spiritual purity.\n\nHistorically, Jain communities have played a role in shaping cultural and economic activities in the region, and the temple stands as a reminder of that heritage. Religious ceremonies and gatherings continue to preserve these traditions.\n\nToday, the temple serves as both a place of worship and a cultural landmark, drawing visitors who appreciate its historical significance and calm atmosphere.",
            "Jintur Jain Temple",
            19.6160,
            76.6950,
            Arrays.asList(
                R.drawable.aaaa,
                R.drawable.bbbb,
                R.drawable.cccc
            ),
            "RELIGIOUS"
        ));

        // 5️⃣ Haji Malang Baba Dargah (Local Shrine)
        cachedPlaces.add(new TouristPlaceModel(
            "Haji Malang Baba Dargah (Local Shrine)",
            "A respected local shrine visited by devotees for blessings and spiritual faith.",
            "Haji Malang Baba Dargah is a respected local shrine that holds deep spiritual importance for devotees in and around Parbhani. The dargah is associated with faith, devotion, and local traditions that have been preserved over time.\n\nThe shrine represents the influence of Sufi culture in the region, emphasizing unity, compassion, and spiritual devotion. Visitors often come to offer prayers and seek blessings, believing in the spiritual power associated with the site.\n\nOver the years, the dargah has become part of the cultural identity of local communities. Religious gatherings and special occasions bring devotees together, reflecting the shared spiritual heritage of the area.\n\nToday, Haji Malang Baba Dargah continues to serve as a place of faith and reflection, attracting people who seek peace and spiritual connection.",
            "Haji Malang Baba Dargah",
            19.2700,
            76.7700,
            new ArrayList<>(),
            "RELIGIOUS"
        ));

        // --- HISTORICAL ---

        // 1️⃣ Aundha Nagnath Jyotirlinga Temple
        cachedPlaces.add(new TouristPlaceModel(
            "Aundha Nagnath Jyotirlinga Temple",
            "Ancient Shiva temple and sacred Jyotirlinga known for historical and spiritual significance.",
            "Aundha Nagnath Temple is one of the most historically and religiously significant temples located near Parbhani district and is believed to be among the twelve sacred Jyotirlingas dedicated to Lord Shiva. The temple has a deep connection with ancient Hindu mythology and is mentioned in various religious texts. It attracts thousands of devotees every year who visit for spiritual purposes and to experience its historical importance.\n\nArchitecturally, the temple is known for its Hemadpanthi style, characterized by strong stone construction and intricate carvings that reflect medieval craftsmanship. Historians believe that the temple dates back several centuries, making it one of the oldest surviving religious structures in the region. The temple has witnessed various cultural and historical transitions yet continues to remain an active spiritual center.\n\nThe temple plays a significant role during major festivals such as Maha Shivaratri, when devotees gather in large numbers to perform rituals and participate in celebrations. Over time, Aundha Nagnath has become a major pilgrimage site and contributes significantly to religious tourism in Maharashtra.\n\nToday, the temple stands as a symbol of ancient heritage, spirituality, and architectural excellence, preserving centuries of history while continuing to serve as an important place of worship.",
            "Aundha Nagnath Temple",
            19.5400,
            77.0500,
            Arrays.asList(
                R.drawable.aa,
                R.drawable.bb,
                R.drawable.cc
            ),
            "HISTORICAL"
        ));

        // 2️⃣ Charthana Hemadpanthi Temples
        cachedPlaces.add(new TouristPlaceModel(
            "Charthana Hemadpanthi Temples",
            "Ancient temple complex known for medieval Hemadpanthi architecture.",
            "Charthana village is known for its collection of ancient Hemadpanthi-style temples that reflect the historical and architectural richness of the region. These temples are believed to have been constructed during the medieval period under the influence of regional dynasties that promoted temple architecture and religious development.\n\nThe Hemadpanthi style is characterized by the use of large stone blocks fitted together without mortar, showcasing advanced engineering techniques for its time. The temples in Charthana demonstrate a blend of artistic craftsmanship and spiritual significance, making them important historical landmarks.\n\nHistorically, these temples served as centers of religious activity and community gatherings. They represent the cultural evolution of the region and highlight the importance of temple architecture in shaping local traditions and social life.\n\nToday, the Charthana temple complex attracts visitors interested in history, architecture, and heritage exploration, offering insight into the medieval past of the Parbhani region.",
            "Charthana Temple Complex",
            19.3500,
            76.9500,
            Arrays.asList(
                R.drawable.char_a,
                R.drawable.char_b,
                R.drawable.char_c
            ),
            "HISTORICAL"
        ));

        // 3️⃣ Jintur Jain Heritage Temples
        cachedPlaces.add(new TouristPlaceModel(
            "Jintur Jain Heritage Temples",
            "Historic Jain temples reflecting ancient religious architecture and heritage.",
            "The Jain temples located in Jintur represent an important historical and cultural heritage associated with the Jain community. These temples are known for their peaceful atmosphere and traditional design, reflecting the philosophical principles of Jainism such as non-violence, discipline, and spiritual purity.\n\nHistorically, the Jain community played a significant role in trade, culture, and religious activities in the region, and these temples stand as evidence of that influence. The architectural style showcases intricate carvings and symbolic elements that reflect Jain traditions.\n\nOver centuries, the temples have served as spiritual centers where devotees gather for worship, meditation, and religious ceremonies. Their preservation highlights the region’s diverse cultural and religious history.\n\nToday, Jintur Jain temples continue to attract both pilgrims and tourists interested in historical heritage and religious architecture.",
            "Jintur Jain Temple",
            19.6160,
            76.6950,
            Arrays.asList(
                R.drawable.aaaa,
                R.drawable.bbbb,
                R.drawable.cccc
            ),
            "HISTORICAL"
        ));

        // 4️⃣ Gangakhed Sant Janabai Temple
        cachedPlaces.add(new TouristPlaceModel(
            "Gangakhed Sant Janabai Temple",
            "Historical religious site associated with Bhakti movement saint Janabai.",
            "Gangakhed is historically associated with Sant Janabai, a prominent saint of the Bhakti movement who is remembered for her devotional poetry and spiritual contributions. The temple dedicated to Sant Janabai holds cultural and historical importance, reflecting the influence of the Bhakti tradition in Maharashtra.\n\nThe site attracts devotees who come to pay homage and learn about the saint’s teachings, which emphasized devotion, humility, and spiritual equality. Historically, the region has served as a center for religious gatherings and cultural expression.\n\nThe temple’s surroundings, located near the Godavari river, add to its spiritual significance and scenic appeal. Festivals and religious events held here continue to preserve traditional practices and strengthen community bonds.\n\nToday, the temple remains a place of devotion and historical remembrance, symbolizing the region’s spiritual heritage.",
            "Gangakhed Sant Janabai Temple",
            18.9700,
            76.7500,
            Arrays.asList(
                R.drawable.gangakhed_sant_a,
                R.drawable.gangakhed_sant_b,
                R.drawable.gangakhed_sant_c
            ),
            "HISTORICAL"
        ));

        // 5️⃣ Selu Old Historical Area / Fort Remains
        cachedPlaces.add(new TouristPlaceModel(
            "Selu Old Historical Area / Fort Remains",
            "Historical settlement area known for old fort remnants and regional heritage.",
            "Selu town has historical significance due to its association with ancient settlements and remnants of old fort structures that reflect the region’s past. While many parts of the original fortifications no longer remain fully intact, the area still holds cultural and historical value.\n\nHistorically, such forts served as defensive structures and administrative centers during earlier periods, contributing to the political and military history of the region. The remains provide insight into local architectural styles and settlement patterns.\n\nThe historical area around Selu reflects the evolution of the region from ancient times to the present, showcasing layers of history influenced by different ruling periods.\n\nToday, the site represents a historical landmark that offers visitors a glimpse into the region’s past and serves as a reminder of its heritage.",
            "Selu Historical Area",
            19.4500,
            76.4500,
            Arrays.asList(
                R.drawable.seluold_a,
                R.drawable.seluold_b,
                R.drawable.seluold_c
            ),
            "HISTORICAL"
        ));

        // --- NATURE_SCENIC ---

        // 1️⃣ Yeldari Dam
        cachedPlaces.add(new TouristPlaceModel(
            "Yeldari Dam",
            "A scenic dam surrounded by natural landscapes, popular for peaceful views and local tourism.",
            "Yeldari Dam is one of the significant water reservoirs in the region and plays an important role in irrigation and water management. Built as part of regional development projects, the dam has gradually become a scenic destination for visitors seeking natural beauty and calm surroundings. The wide water spread and surrounding greenery create a peaceful environment ideal for relaxation and photography. Over time, locals have started visiting the area for picnics and nature exploration, making it a notable natural attraction near Parbhani.",
            "Yeldari Dam",
            19.5000,
            76.8000,
            Arrays.asList(
                R.drawable.yel_a,
                R.drawable.yel_b,
                R.drawable.yel_c,
                R.drawable.yel_d
            ),
            "NATURE_SCENIC"
        ));

        // 2️⃣ Masoli Dam
        cachedPlaces.add(new TouristPlaceModel(
            "Masoli Dam",
            "A quiet natural water body known for serene views and rural scenic beauty.",
            "Masoli Dam is a lesser-known yet beautiful water reservoir located near Parbhani. Surrounded by natural terrain and rural landscapes, the area offers a peaceful escape from urban life. Historically developed for irrigation and water storage, the dam has become a favorite spot for locals who appreciate nature and calm environments. The natural setting provides opportunities for relaxation, photography, and experiencing local ecological surroundings.",
            "Masoli Dam",
            19.3200,
            76.8200,
            Arrays.asList(
                R.drawable.mas_a,
                R.drawable.mas_b
            ),
            "NATURE_SCENIC"
        ));

        // 3️⃣ Gangakhed Godavari River Ghats
        cachedPlaces.add(new TouristPlaceModel(
            "Gangakhed Godavari River Ghats",
            "Sacred riverbank area offering scenic views along the Godavari river.",
            "Gangakhed, located along the banks of the Godavari River, holds both natural and cultural importance. The river ghats provide scenic views of flowing water and natural surroundings, attracting visitors interested in peaceful landscapes. Historically, the area has been associated with religious gatherings and local traditions, making it both a spiritual and natural destination. The combination of river views, traditional architecture, and cultural activities makes Gangakhed a significant location for visitors.",
            "Gangakhed Godavari Ghats",
            18.9700,
            76.7500,
            Arrays.asList(
                R.drawable.gan_a,
                R.drawable.gan_b,
                R.drawable.gan_c,
                R.drawable.gan_d
            ),
            "NATURE_SCENIC"
        ));

        // 4️⃣ Pingli Lake
        cachedPlaces.add(new TouristPlaceModel(
            "Pingli Lake",
            "A natural lake area offering calm surroundings and scenic water views.",
            "Pingli Lake is a local natural attraction known for its peaceful environment and scenic beauty. The lake supports local biodiversity and serves as a relaxing destination for visitors seeking natural landscapes. Over time, the area has become popular among locals for evening visits and nature observation. The combination of water, greenery, and open skies makes it an appealing location for nature lovers.",
            "Pingli Lake",
            19.2800,
            76.7700,
            Arrays.asList(
                R.drawable.pin
            ),
            "NATURE_SCENIC"
        ));

        // 5️⃣ Jintur Hills
        cachedPlaces.add(new TouristPlaceModel(
            "Jintur Hills",
            "Natural hill region offering elevated scenic views and peaceful natural surroundings.",
            "The hill regions around Jintur provide a unique natural landscape within the Parbhani district. These elevated areas offer scenic viewpoints and a peaceful atmosphere away from crowded city spaces. Historically, the region has maintained its natural terrain, making it suitable for nature exploration and photography. Visitors appreciate the panoramic views and quiet environment, which highlight the natural beauty of the area.",
            "Jintur Hills",
            19.6160,
            76.6950,
            Arrays.asList(
                R.drawable.jin_a,
                R.drawable.jin_b,
                R.drawable.jin_c,
                R.drawable.jin_d,
                R.drawable.jin_e
            ),
            "NATURE_SCENIC"
        ));

        // --- EDUCATIONAL_PUBLIC ---
        cachedPlaces.add(new TouristPlaceModel(
            "Public Library",
            "Information and educational hub.",
            "Detailed history of the library...",
            "Main Market",
            19.2690,
            76.7800,
            Arrays.asList(
                R.drawable.lib_a,
                R.drawable.lib_b,
                R.drawable.lib_c,
                R.drawable.lib_d,
                R.drawable.lib_e,
                R.drawable.lib_f,
                R.drawable.lib_g,
                R.drawable.lib_h,
                R.drawable.lib_i
            ),
            "EDUCATIONAL_PUBLIC"
        ));

        return cachedPlaces;
    }
}
