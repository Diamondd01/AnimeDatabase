package com.devmountain.Capstone2.dataInitialization;


import com.devmountain.Capstone2.entites.AnimeCharacter;
import com.devmountain.Capstone2.repository.AnimeCharacterRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer {

    private final AnimeCharacterRepository characterRepository;

    @Autowired
    public DataInitializer(AnimeCharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @PostConstruct
    public void initializeData() {
        //Inserts AnimeCharacter data

        AnimeCharacter character1 = new AnimeCharacter();
        character1.setName("Izuku Midoriya");
        character1.setDescription("Izuku Midoriya is also known as Deku. He is the Main Charater.Izuku is a very timid, reserved, and polite boy, frequently overreacting to abnormal situations with exaggerated expressions. He was born without a Quirk," +
                " however he caught the attention of the legendary here All Might. Prior to receiving a quirk from All Might his power was only knowledge of being a hero. Later he obtained the One For All quirk from All Might.");
        character1.setImageUrl("Izuku Midoriya.png");

        AnimeCharacter character2 = new AnimeCharacter();
        character2.setName("Katsuki Bakugo");
        character2.setDescription("Quirk: Explosion. Generates and controls explosions from his sweat.");
        character2.setImageUrl("Katsuki Bakugo.png");

        AnimeCharacter character3 = new AnimeCharacter();
        character3.setName("Ochaco Uraraka");
        character3.setDescription("Quirk: Zero Gravity. She can make objects float by touching them.");
        character3.setImageUrl("Ochaco Uraraka.png");

        AnimeCharacter character4 = new AnimeCharacter();
        character4.setName("Tenya Iida");
        character4.setDescription("Quirk: Engine. Grants him super-speed with engines in his legs.");
        character4.setImageUrl("Tenya Iida.png");

        AnimeCharacter character5 = new AnimeCharacter();
        character5.setName("Tsuyu Asui");
        character5.setDescription("Quirk: Frog. Gives her a frog-like appearance and abilities, including a long tongue and wall-crawling.");
        character5.setImageUrl("Tsuyu Asui.png");

        AnimeCharacter character6 = new AnimeCharacter();
        character6.setName("Shoto Todoroki");
        character6.setDescription("Quirk: Half-Cold Half-Hot. Allows him to control ice with his left side and fire with his right.");
        character6.setImageUrl("Shoto Todoroki.png");

        AnimeCharacter character7 = new AnimeCharacter();
        character7.setName("Eijiro Kirishima");
        character7.setDescription(" Quirk: Hardening. Turns his body into a nearly indestructible rock-like form.");
        character7.setImageUrl("Eijiro Kirishima.png");

        AnimeCharacter character8 = new AnimeCharacter();
        character8.setName("Momo Yaoyorozu");
        character8.setDescription("Quirk: Creation. Enables her to create any non-living object from her body, as long as she understands its molecular structure.");
        character8.setImageUrl("Momo Yaoyorozu.png");

        AnimeCharacter character9 = new AnimeCharacter();
        character9.setName("Denki Kaminari");
        character9.setDescription("Quirk: Electrification. He can release and control electricity but becomes brain-dead if he overuses it.");
        character9.setImageUrl("Denki Kaminari.png");

        AnimeCharacter character10 = new AnimeCharacter();
        character10.setName("Kyoka Jiro");
        character10.setDescription("Quirk: Earphone Jack. Allows her to turn her earlobes into powerful earphone jacks to transmit sound.");
        character10.setImageUrl("image-url-3.jpg");

        AnimeCharacter character11 = new AnimeCharacter();
        character11.setName("Neito Monoma");
        character11.setDescription("Quirk: Copy. He can temporarily copy another person's Quirk by touching them.");
        character11.setImageUrl("image-url-3.jpg");

        AnimeCharacter character12 = new AnimeCharacter();
        character12.setName("Kyoka Jiro");
        character12.setDescription("Quirk: Big Fist. Increases the size and power of her fists.");
        character12.setImageUrl("image-url-3.jpg");

        AnimeCharacter character13 = new AnimeCharacter();
        character13.setName("Tetsutetsu Tetsutetsu");
        character13.setDescription("Quirk: Steel. Turns his skin into steel, granting him enhanced durability.");
        character13.setImageUrl("image-url-3.jpg");

        AnimeCharacter character14 = new AnimeCharacter();
        character14.setName("Setsuna Tokage");
        character14.setDescription("Quirk: Lizard Tail Splitter. She can split her body into multiple pieces and control them independently.");
        character14.setImageUrl("image-url-3.jpg");

        AnimeCharacter character15 = new AnimeCharacter();
        character15.setName("Pony Tsunotori");
        character15.setDescription("Quirk: Horn Cannon. She has a horn on her forehead that can shoot energy blasts.");
        character15.setImageUrl("image-url-3.jpg");

        AnimeCharacter character16 = new AnimeCharacter();
        character16.setName("Reiko Yanagi");
        character16.setDescription(" Quirk: Poltergeist. Allows her to make objects float and move telekinetically.");
        character16.setImageUrl("image-url-3.jpg");

        AnimeCharacter character17 = new AnimeCharacter();
        character17.setName("All Might (Toshinori Yagi)");
        character17.setDescription("Quirk: One For All (formerly). He was the Symbol of Peace, possessing immense super-strength and speed.");
        character17.setImageUrl("image-url-3.jpg");


        AnimeCharacter character18 = new AnimeCharacter();
        character18.setName("Endeavor (Enji Todoroki)");
        character18.setDescription("Quirk: Hellflame. He can generate and control extremely powerful flames.");
        character18.setImageUrl("image-url-3.jpg");


        AnimeCharacter character19 = new AnimeCharacter();
        character19.setName("Hawks (Keigo Takami)");
        character19.setDescription("Quirk: Fierce Wings. He has large wings and can manipulate feathers as deadly projectiles.");
        character19.setImageUrl("image-url-3.jpg");


        AnimeCharacter character20 = new AnimeCharacter();
        character20.setName("Best Jeanist (Tsunagu Hakamata)");
        character20.setDescription("Quirk: Fiber Master. He controls and shapes threads made from his own hair.");
        character20.setImageUrl("image-url-3.jpg");


        AnimeCharacter character21 = new AnimeCharacter();
        character21.setName("Shota Aizawa ");
        character21.setDescription("Quirk: Erasure. He can cancel out other people's Quirks by looking at them.");
        character21.setImageUrl("image-url-3.jpg");

        // Saves the characters to the database
        characterRepository.save(character1);
        characterRepository.save(character2);
        characterRepository.save(character3);
        characterRepository.save(character4);
        characterRepository.save(character5);
        characterRepository.save(character6);
        characterRepository.save(character7);
        characterRepository.save(character8);
        characterRepository.save(character9);
        characterRepository.save(character10);
        characterRepository.save(character11);
        characterRepository.save(character12);
        characterRepository.save(character13);
        characterRepository.save(character14);
        characterRepository.save(character15);
        characterRepository.save(character16);
        characterRepository.save(character17);
        characterRepository.save(character18);
        characterRepository.save(character19);
        characterRepository.save(character20);
        characterRepository.save(character21);
    }
}
