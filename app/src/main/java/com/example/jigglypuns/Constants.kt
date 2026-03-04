package com.example.jigglypuns

object Constants {

    fun getQuestions(): ArrayList<Questions> {

        val questionsList = ArrayList<Questions>()

        val que1 = Questions(
            1,
            "What do you call a Pikachu that can fix computers?",
            R.drawable.pikachu,
            "Geek-achu",
            "Pikaboo",
            "Vulfix-it",
            "Zaptos Intolerant",
            1
        )

        questionsList.add(que1)

        val que2 = Questions(
            2,
            "What Pokemon does Dracula like?",
            R.drawable.koffin,
            "Iyysaur",
            "Koffin",
            "Prince Charmander",
            "Wynaut",
            2
        )

        questionsList.add(que2)

        val que3 = Questions(
            3,
            "Which Pokemon could also be a pirate?",
            R.drawable.arbok,
            "Chiazard",
            "Wynaut",
            "Chikorita",
            "Arrrrrr-bok",
            4
        )

        questionsList.add(que3)

        val que4 = Questions(
            4,
            "I asked my dad why a grown man would play Pokemon Go? He said, ",
            R.drawable.wynaut,
            "Hitmonlee",
            "Mewtwo",
            "Wynaut",
            "Zaptos",
            1
        )

        questionsList.add(que4)

        val que5 = Questions(
            5,
            "Why did the Squirtle cross the ocean?",
            R.drawable.squirtle,
            "Because it was there.",
            "He was hot.",
            "To play pika-boo",
            "To get to the other tide.",
            4
        )

        questionsList.add(que5)

        val que6 = Questions(
            6,
            "Why can't you blindfold a Pokemon?",
            R.drawable.pokemon,
            "Because it's going to Pikachu!",
            "Ekans see clearly now, the rain has gone.",
            "They can't see it tine can fly.",
            "Wynaut try.",
            1
        )

        questionsList.add(que6)

        val que7 = Questions(
            7,
            "What do you call a Weedle who does stunts on a motorcycle?",
            R.drawable.weedle,
            "Weedle Knievel",
            "The Great Gastly",
            "Kakuna Rattata",
            "A LightBulbasaur",
            1
        )

        questionsList.add(que7)

        val que8 = Questions(
            8,
            "What did the judge say when a Skuntank came into the court?",
            R.drawable.skuntank,
            "I see you've bitten off more than you can pikachu.",
            "Odor in the court!",
            "I shoudl've kept my big meowth shut.",
            "The Pokeball's in your court.",
            2
        )

        questionsList.add(que8)

        val que9 = Questions(
            9,
            "What do you call Meowth's reflection?",
            R.drawable.meow,
            "This is a real cat-has-trophy.",
            "Keep your Meowth shut.",
            "A copycat.",
            "Watch out for the tree, it has bark.",
            1
        )

        questionsList.add(que9)

        val que10 = Questions(
            10,
            "What happened when bubasaur accidentally hurt himself?",
            R.drawable.bulbasaur,
            "He cried.",
            "He was Bulbasore.",
            "67 hehe",
            "He wasn't Dowzee anymore.",
            3
        )

        questionsList.add(que10)

        return questionsList
    }
}