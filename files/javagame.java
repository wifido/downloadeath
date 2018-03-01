{\rtf1\ansi\ansicpg1251\cocoartf1504\cocoasubrtf830
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0  /* To change this license header, choose License Headers in Project Properties.\
 * To change this template file, choose Tools | Templates\
 * and open the template in the editor.\
 */\
package javaworld;\
\
import java.io.BufferedReader;\
import java.io.BufferedWriter;\
import java.io.File;\
import java.io.FileReader;\
import java.io.FileWriter;\
import java.io.IOException;\
import java.io.Reader;\
import java.io.Writer;\
import java.nio.file.Files;\
import java.nio.file.Path;\
import java.nio.file.Paths;\
import java.util.Arrays;\
import java.util.Scanner;\
\
/**\
 *\
 * @author W10\
 */\
public class JavaWorld \{\
\
    public static int SIZE = 40;\
    public static char[][] gameTable = new char[SIZE][SIZE];\
    public static char grass = '.';\
    public static char tree = '#';\
    public static char stone = '@';\
    public static char wood = '%';\
    public static char EMPTY = ' ';\
    public static char gold = '$';\
    public static String fileName = "C:\\\\Users\\\\W10\\\\Documents\\\\JavaWorld\\\\world";\
    public static char day = 'D';\
    public static char apple = '\uc0\u334 ';\
    public static int starfallregul;\
    public static double applecolvo;\
    public static double hungry = 100.0;\
    public static String hungryM = "I'm not very hungry";\
    public static String hungryN = "I'm need eat";\
    public static String hungryD = "I'm Died";\
    public static String hungryF = "I'm full";\
    public static boolean clock;\
    public static double clock1 = 0;\
    public static double died1 = 0;\
    public static boolean died = false;\
    public static char night = 'N';\
    public static double time = 0.0;\
    public static double invstarcolvo;\
    public static int inventorycolvo;\
    public static char time1 = day;\
    public static char star = 'X';\
    public static int starcolvo;\
    public static int istar;\
    public static int jstar;\
    public static char player = 'Q';\
    public static char stenkawood = 'W';\
    public static double autosave;\
    public static double stenkawoodcolvo;\
    public static int secretweapon1;\
    public static char monster = 'G';\
    public static char nothing;\
    public static boolean stenkawoodor;\
    public static char object;\
    public static char iron = 'M';\
    public static char chestinv1;\
    public static int chestinv1colvo;\
    public static char chestinv2;\
    public static int chestinv2colvo;\
    public static char chestinv3;\
    public static int chestinv3colvo;\
    public static char chestinv4;\
    public static int chestinv4colvo;\
    public static char chestinv5;\
    public static int chestinv5colvo;\
    public static char inventory1 = 'N';\
    public static double woodcolvo;\
    public static double ironcolvo;\
    public static char secretweapon = 'S';\
    public static boolean secretweaponor;\
    public static double goldcolvo;\
    public static char onhand;\
    public static boolean invchest;\
    public static double chestcolvo;\
    public static char chest = '=';\
    public static double stonecolvo;\
    public static boolean woodpickaxe;\
    public static double prochwoodpickaxe;\
    public static char woodpickaxe1 = 'T';\
    public static boolean stonepickaxe;\
    public static double prochstonepickaxe;\
    public static double prochironpickaxe;\
    public static boolean ironpickaxe;\
    public static char ironpickaxe1 = 'T';\
    public static double prochhamer;\
    public static boolean hamer;\
    public static char hamer1 = 'T';\
    public static char stonepickaxe1 = 'T';\
    public static char piganimal = 'O';\
\
    /**\
     */\
    public static void createworld() \{\
        for (int i = 0; i < SIZE; i++) \{\
            for (int j = 0; j < SIZE; j++) \{\
                int v = (int) (Math.random() * 10);\
                if (v == 1) \{\
                    object = grass;\
                \}\
                if (v == 2) \{\
                    object = tree;\
                \}\
                if (v == 3) \{\
                    object = stone;\
                \}\
                if (v == 4) \{\
                    object = EMPTY;\
                \}\
                if (v == 5) \{\
                    object = EMPTY;\
                \}\
                if (v == 6) \{\
                    object = iron;\
                \}\
                if (v == 7) \{\
                    object = EMPTY;\
                \}\
                if (v == 8) \{\
                    object = tree;\
                \}\
                if (v == 9) \{\
                    object = gold;\
                \}\
                if (v == 10) \{\
                    object = EMPTY;\
                \}\
                if (gameTable[i][j] == gameTable[0][0]) \{\
                    object = player;\
                \}\
                gameTable[i][j] = object;\
                System.out.print(gameTable[i][j]);\
            \}\
            System.out.println();\
        \}\
        fix();\
    \}\
\
    public static void deleteworld() \{\
        Path xPath = Paths.get(fileName);\
        try \{\
            Files.delete(xPath);\
            System.out.println("world deleted");\
            mainmenu();\
        \} catch (Exception e) \{\
            System.out.println("World not deleted");\
            mainmenu();\
        \}\
    \}\
\
    public static void dieddeleteworld() \{\
        Path xPath = Paths.get(fileName);\
        try \{\
            Files.delete(xPath);\
            mainmenu();\
        \} catch (Exception e) \{\
            mainmenu();\
        \}\
    \}\
    \
    public static void fix() \{\
        if (gameTable[0][1] == player) \{\
            object = EMPTY;\
            gameTable[0][1] = object;\
        \}\
        if (gameTable[0][1] == iron || gameTable[0][1] == gold || gameTable[0][1] == stone) \{\
            object = EMPTY;\
            gameTable[0][1] = object;\
        \}\
        if (gameTable[1][0] == iron || gameTable[1][0] == gold || gameTable[1][0] == stone) \{\
            object = EMPTY;\
            gameTable[1][0] = object;\
        \}\
        System.out.println("fix succefull");\
        System.out.println();\
        pole();\
    \}\
\
    public static void save() \{\
        try (Writer wr = new BufferedWriter(new FileWriter("world"))) \{\
            for (int i = 0; i < gameTable.length; i++) \{\
                for (int j = 0; j < gameTable[i].length; j++) \{\
                    wr.write(String.valueOf(gameTable[i][j]));\
                \}\
            \}\
            wr.flush();\
        \} catch (IOException e) \{\
            Arrays.hashCode(new int[]\{\});\
        \}\
    \}\
\
    public static void load() \{\
        File file = new File("world");\
        if (file.exists()) \{\
            try (Reader reader = new BufferedReader(new FileReader(file))) \{\
                for (int i = 0; i < gameTable.length; i++) \{\
                    for (int j = 0; j < gameTable[i].length; j++) \{\
                        gameTable[i][j] = (char) reader.read();\
                    \}\
                \}\
            \} catch (IOException e) \{\
            \}\
        \}\
        pole();\
    \}\
\
    private static void readLines1() throws IOException \{\
        try (BufferedReader br = new BufferedReader(\
                new FileReader("world.txt"))) \{\
            String line = null;\
            while ((line = br.readLine()) != null) \{\
\
            \}\
        \}\
    \}\
\
    public static void items() \{\
        if (prochwoodpickaxe > 0.1) \{\
            woodpickaxe = true;\
        \}\
        if (prochwoodpickaxe == 1.0) \{\
            woodpickaxe = false;\
            onhand = nothing;\
            prochwoodpickaxe = 0;\
            System.out.println("pickaxe lost");\
        \}\
        if (chestcolvo >= 1) \{\
            invchest = true;\
        \}\
        if (chestcolvo < 1)\{\
            invchest = false;\
            if (onhand == chest)\{\
                onhand = nothing;\
            \}\
        \}\
        if (prochstonepickaxe == 1.0) \{\
            woodpickaxe = false;\
            onhand = nothing;\
            prochstonepickaxe = 0;\
            System.out.println("pickaxe lost");\
        \}\
        if (prochstonepickaxe > 0.1) \{\
            stonepickaxe = true;\
        \}\
        if (prochironpickaxe == 1.0) \{\
            woodpickaxe = false;\
            onhand = nothing;\
            prochstonepickaxe = 0;\
            System.out.println("pickaxe lost");\
        \}\
        if (prochironpickaxe > 0.1) \{\
            stonepickaxe = true;\
        \}\
        if (stenkawoodcolvo > 0.1) \{\
            stenkawoodor = true;\
        \}\
        if (clock1 == 1) \{\
            clock = true;\
        \}\
        if (secretweapon1 == 1) \{\
            secretweaponor = true;\
        \}\
    \}\
\
    public static void autosaveworld() \{\
        if (autosave == 10) \{\
            autosave = 0.0;\
            System.out.println();\
            save();\
        \}\
    \}\
\
    public static void time() \{\
        if (time == 0.0) \{\
            time1 = day;\
        \}\
        if (time == 25) \{\
            time1 = night;\
        \}\
        if (time == 50) \{\
            time = 0.0;\
            time1 = day;\
        \}\
    \}\
\
    public static void hungrydied() \{\
        if (hungry <= 0) \{\
            died = true;\
            died1 = 1;\
        \}\
    \}\
\
    public static void died() \{\
        if (died == true || died1 == 1) \{\
            System.out.println("you're died");\
            dieddeleteworld();\
            mainmenu();\
        \}\
    \}\
\
    public static void nighttime() \{\
        if (time1 == night) \{\
            if (starcolvo == 0)\{\
                int starxans = (int) (Math.random() * 4);\
                if (starxans == 2)\{\
                    istar = (int) (Math.random() * 44);\
                    jstar = (int) (Math.random() * 44);\
                    if (gameTable[istar][jstar] == EMPTY || gameTable[istar][jstar] == grass) \{\
                        starcolvo++;\
                        object = star;\
                        starfallregul++;\
                        gameTable[istar][jstar] = object;\
                        System.out.println("The Star is fall");\
                        pole();\
                    \}\
                \} else \{\
                    starfallregul++;\
                    System.out.println();\
                    pole();\
                \}\
            \}\
        \}\
    \}\
\
    public static void xodplayer() \{\
        items();\
        autosaveworld();\
        time();\
        hungrydied();\
        died();\
        if (time1 == day)\{\
            starfallregul = 0;\
        \}\
        if (starfallregul == 0)\{\
        nighttime();\
        \}\
        for (int i = 0; i < SIZE; i++) \{\
            for (int j = 0; j < SIZE; j++) \{\
                if (gameTable[i][j] == player) \{\
                    String vibor = new Scanner(System.in).nextLine();\
                    if ("save".equals(vibor)) \{\
                        save();\
                    \}\
                    if ("exit".equals(vibor)) \{\
                        mainmenu();\
                    \}\
                    \
                    if ("god".equals(vibor)) \{\
                        woodcolvo = 99;\
                        stonecolvo = 99;\
                        ironcolvo = 99;\
                        goldcolvo = 99;\
                        secretweapon1 = 1;\
                        secretweaponor = true;\
                        stonepickaxe = true;\
                        prochstonepickaxe = 99;\
                        pole();\
                    \}\
                    if ("inv".equals(vibor)) \{\
                        System.out.println("\{" + onhand + "\}" + " " + "onhand");\
                        System.out.println();\
                        if (time1 == night) \{\
                            System.out.println(time1 + " " + "night");\
                        \}\
                        if (time1 == day) \{\
                            System.out.println(time1 + " " + "day");\
                        \}\
                        if (hungry <= 6) \{\
                            System.out.println();\
                            System.out.println(hungryD);\
                        \}\
                        if (hungry <= 27 && hungry > 6) \{\
                            System.out.println();\
                            System.out.println(hungryN);\
                        \}\
                        if (hungry <= 52 && hungry > 27) \{\
                            System.out.println();\
                            System.out.println(hungryM);\
                        \}\
                        if (hungry <= 100 && hungry > 52) \{\
                            System.out.println();\
                            System.out.println(hungryF);\
                        \}\
                        if (clock == true) \{\
                            System.out.println();\
                            System.out.println(time + " " + "time");\
                        \}\
                        if (prochhamer > 0 && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(hamer1 + " " + "hamer");\
                            System.out.println(prochhamer);\
                        \}\
                        if (applecolvo > 0 && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(apple + " " + "apple");\
                            System.out.println(applecolvo);\
                        \}\
                        if (woodcolvo > 0 && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(wood + " " + "wood");\
                            System.out.println(woodcolvo);\
                        \}\
                        if (invstarcolvo > 0 && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(star + " " + "star");\
                            System.out.println(invstarcolvo);\
                        \}\
                        if (secretweaponor == true) \{\
                            System.out.println();\
                            System.out.println(secretweapon + " " + "secret");\
                        \}\
                        if (woodpickaxe == true && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(woodpickaxe1 + " " + "woodpickaxe");\
                            System.out.println(prochwoodpickaxe);\
                        \}\
                        if (stonecolvo > 0  && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(stone + " " + "stone");\
                            System.out.println(stonecolvo);\
                        \}\
                        if (stenkawoodcolvo > 0 && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(stenkawood + " " + "stenawood");\
                            System.out.println(stonecolvo);\
                        \}\
                        if (goldcolvo > 0 && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(gold + " " + "gold");\
                            System.out.println(goldcolvo);\
                        \}\
                        if (ironcolvo > 0 && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(iron + " " + "iron");\
                            System.out.println(ironcolvo);\
                        \}\
                        if (chestcolvo > 0 && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(chest + " " + "chest");\
                            System.out.println(chestcolvo);\
                        \}\
                        if (stonepickaxe == true  && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(stonepickaxe1 + " " + "stonepickaxe");\
                            System.out.println(prochstonepickaxe);\
                        \}\
                        if (ironpickaxe == true  && inventorycolvo <= 8) \{\
                            System.out.println();\
                            System.out.println(ironpickaxe1 + " " + "ironpickaxe");\
                            System.out.println(prochironpickaxe);\
                        \}\
                        System.out.println();\
                        System.out.println("craftmenu [craft]");\
                        String a = new Scanner(System.in).nextLine();\
                        if ("q".equals(a)) \{\
                            pole();\
                        \}\
                        if ("apple".equals(a)) \{\
                            if (applecolvo >= 1) \{\
                                applecolvo--;\
                                hungry++;\
                                hungry++;\
                                hungry++;\
                                hungry++;\
                                hungry++;\
                                hungry++;\
                                hungry++;\
                                hungry++;\
                                pole();\
                            \} else \{\
                                System.out.println("you dont have any apples");\
                                pole();\
                            \}\
                        \}\
\
                        if ("chest".equals(a)) \{\
                            if (invchest == true) \{\
                                if (invchest == true) \{\
                                    onhand = chest;\
                                    pole();\
                                \} else \{\
                                    System.out.println("you don't have this");\
                                    pole();\
                                \}\
                            \}\
                        \}\
\
                        if ("hamer".equals(a)) \{\
                            if (hamer == true) \{\
                                if (hamer == true) \{\
                                    onhand = hamer1;\
                                    pole();\
                                \} else \{\
                                    System.out.println("you don't have this");\
                                    pole();\
                                \}\
                            \}\
                        \}\
\
                        if ("secretweapon".equals(a)) \{\
                            if (secretweaponor == true) \{\
                                if (secretweaponor == true) \{\
                                    onhand = secretweapon;\
                                    pole();\
                                \} else \{\
                                    System.out.println("you don't have this");\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if ("stonepickaxe".equals(a)) \{\
                            if (stonepickaxe == true) \{\
                                if (stonepickaxe == true) \{\
                                    onhand = stonepickaxe1;\
                                    pole();\
                                \} else \{\
                                    System.out.println("you don't have this");\
                                    pole();\
                                \}\
                            \}\
                        \}\
\
                        if ("ironpickaxe".equals(a)) \{\
                            if (ironpickaxe == true) \{\
                                if (ironpickaxe == true) \{\
                                    onhand = ironpickaxe1;\
                                    pole();\
                                \} else \{\
                                    System.out.println("you don't have this");\
                                    pole();\
                                \}\
                            \}\
                        \}\
\
                        if ("woodpickaxe".equals(a)) \{\
                            if (woodpickaxe == true) \{\
                                onhand = woodpickaxe1;\
                                System.out.println("Susccefully");\
                                pole();\
                            \} else \{\
                                System.out.println("you don't have this");\
                                pole();\
                            \}\
                        \}\
                        if ("stenkawood".equals(a)) \{\
                            if (stenkawoodor == true) \{\
                                onhand = stenkawood;\
                                System.out.println("Susccefully");\
                                pole();\
                            \} else \{\
                                System.out.println("you don't have this");\
                                pole();\
                            \}\
                        \}\
\
                        if ("craft".equals(a)) \{\
                            System.out.println("1.woodpickaxe 10 Wood");\
                            System.out.println("2.chest 5 Wood 2 Stone");\
                            System.out.println("3.stonepickaxe 5 Stone 10 Wood");\
                            System.out.println("4.woodstena 5 Wood");\
                            System.out.println("5.ironpickaxe 4 Iron 15 Wood 2 Stone");\
                            System.out.println("6.hamer 7 Iron 20 Wood 4 Gold");\
                            System.out.println("7.clock 2 Iron 8 Gold 1 Star");\
                            System.out.println("press 9 to qiut");\
                            int b = new Scanner(System.in).nextInt();\
                            if (b == 1) \{\
                                if (woodcolvo >= 10) \{\
                                    for (int d = 0; d < 11; d++) \{\
                                        woodcolvo--;\
                                    \}\
                                    woodpickaxe = true;\
                                    prochwoodpickaxe = 12;\
                                    System.out.println("You craft woodpickaxe");\
                                    pole();\
                                \} else \{\
                                    System.out.println("you dont have resourse for it");\
                                    pole();\
                                \}\
                            \}\
\
                            if (b == 6) \{\
                                if (woodcolvo >= 20 && ironcolvo >= 7 && goldcolvo >= 4) \{\
                                    for (int d = 0; d < 21; d++) \{\
                                        woodcolvo--;\
                                    \}\
                                    for (int d = 0; d < 8; d++) \{\
                                        ironcolvo--;\
                                    \}\
                                    for (int d = 0; d < 5; d++) \{\
                                        goldcolvo--;\
                                    \}\
                                    hamer = true;\
                                    prochhamer = 20;\
                                    System.out.println("You craft hamer");\
                                    pole();\
                                \} else \{\
                                    System.out.println("you dont have resourse for it");\
                                    pole();\
                                \}\
                            \}\
\
                            if (b == 7) \{\
                                if (goldcolvo >= 8 && ironcolvo >= 3 && invstarcolvo >= 1) \{\
                                    for (int d = 0; d < 8; d++) \{\
                                        goldcolvo--;\
                                    \}\
                                    for (int d = 0; d < 2; d++) \{\
                                        ironcolvo--;\
                                    \}\
                                    for (int d = 0; d < 1; d++) \{\
                                        invstarcolvo--;\
                                    \}\
                                    clock = true;\
                                    clock1 = 1;\
                                    System.out.println("You craft clock");\
                                    pole();\
                                \} else \{\
                                    System.out.println("you dont have resourse for it");\
                                    pole();\
                                \}\
                            \}\
\
                            if (b == 5) \{\
                                if (woodcolvo >= 15 && stonecolvo >= 2 && ironcolvo >= 4) \{\
                                    for (int d = 0; d < 16; d++) \{\
                                        woodcolvo--;\
                                    \}\
                                    for (int d = 0; d < 3; d++) \{\
                                        stonecolvo--;\
                                    \}\
                                    for (int d = 0; d < 5; d++) \{\
                                        ironcolvo--;\
                                    \}\
                                    ironpickaxe = true;\
                                    prochironpickaxe = 44;\
                                    System.out.println("You craft ironpickaxe");\
                                    pole();\
                                \} else \{\
                                    System.out.println("you dont have resourse for it");\
                                    pole();\
                                \}\
                            \}\
\
                            if (b == 2) \{\
                                if (woodcolvo >= 5 && stonecolvo >= 2) \{\
                                    for (int w = 0; w < 6; w++) \{\
                                        woodcolvo--;\
                                    \}\
                                    for (int s = 0; s < 3; s++) \{\
                                        stonecolvo--;\
                                    \}\
                                    chestcolvo = 1;\
                                    invchest = true;\
                                    System.out.println("You craft chest");\
                                    pole();\
                                \} else \{\
                                    System.out.println("you dont have resourse for it");\
                                    pole();\
                                \}\
                            \}\
                            if (b == 3) \{\
                                if (woodcolvo >= 10 && stonecolvo >= 5) \{\
                                    for (int w = 0; w < 11; w++) \{\
                                        woodcolvo--;\
                                    \}\
                                    for (int s = 0; s < 6; s++) \{\
                                        stonecolvo--;\
                                    \}\
                                    prochstonepickaxe = 22;\
                                    stonepickaxe = true;\
                                    System.out.println("You craft stonepickaxe");\
                                    pole();\
                                \} else \{\
                                    System.out.println("you dont have resourse for it");\
                                    pole();\
                                \}\
                            \}\
                            if (b == 4) \{\
                                if (woodcolvo >= 5) \{\
                                    woodcolvo--;\
                                    woodcolvo--;\
                                    woodcolvo--;\
                                    woodcolvo--;\
                                    woodcolvo--;\
                                    stenkawoodcolvo++;\
                                    stenkawoodor = true;\
                                    System.out.println("You craft stenkawood");\
                                    pole();\
                                \} else \{\
                                    System.out.println("you dont have resourse for it");\
                                    pole();\
                                \}\
                            \}\
                            if (b == 9) \{\
                                pole();\
                            \}\
\
                        \}\
                        pole();\
                    \}\
                    if ("dd".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        hungry--;\
                        if (gameTable[i][j + 2] == EMPTY || gameTable[i][j + 2] == grass) \{\
                            if (gameTable[i][j + 2] == grass) \{\
                                object = player;\
                                gameTable[i][j + 2] = object;\
                                object = grass;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \}\
                        if (gameTable[i][j + 2] == EMPTY || gameTable[i][j + 2] == grass) \{\
                            if (gameTable[i][j + 2] == EMPTY) \{\
                                object = player;\
                                gameTable[i][j + 2] = object;\
                                object = EMPTY;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("sorry its not EMPTY");\
                            vibor = "d";\
                            pole();\
                        \}\
                    \}\
                    if ("aa".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        hungry--;\
                        if (gameTable[i][j - 2] == EMPTY || gameTable[i][j - 2] == grass) \{\
                            if (gameTable[i][j - 2] == grass) \{\
                                object = player;\
                                gameTable[i][j - 2] = object;\
                                object = grass;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                            if (gameTable[i][j - 2] == EMPTY || gameTable[i][j - 2] == grass) \{\
                                if (gameTable[i][j - 2] == EMPTY) \{\
                                    object = player;\
                                    gameTable[i][j - 2] = object;\
                                    object = EMPTY;\
                                    gameTable[i][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \} else \{\
                            System.out.println("sorry its not EMPTY");\
                            vibor = "a";\
                            pole();\
                        \}\
                    \}\
                    if ("ww".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        hungry--;\
                        if (gameTable[i - 2][j] == EMPTY || gameTable[i - 2][j] == grass) \{\
                            if (gameTable[i - 2][j] == grass) \{\
                                object = player;\
                                gameTable[i - 2][j] = object;\
                                object = grass;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \}\
                        if (gameTable[i - 2][j] == EMPTY || gameTable[i - 2][j] == grass) \{\
                            if (gameTable[i - 2][j] == EMPTY) \{\
                                object = player;\
                                gameTable[i - 2][j] = object;\
                                object = EMPTY;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("sorry its not EMPTY");\
                            vibor = "w";\
                            pole();\
                        \}\
                    \}\
                    if ("ss".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        hungry--;\
                        if (gameTable[i + 2][j] == EMPTY || gameTable[i + 2][j] == grass) \{\
                            if (gameTable[i + 2][j] == EMPTY) \{\
                                object = player;\
                                gameTable[i + 2][j] = object;\
                                object = EMPTY;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \}\
                        if (gameTable[i + 2][j] == EMPTY || gameTable[i + 2][j] == grass) \{\
                            if (gameTable[i + 2][j] == grass) \{\
                                object = player;\
                                gameTable[i + 2][j] = object;\
                                object = grass;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("sorry its not EMPTY");\
                            vibor = "s";\
                            pole();\
                        \}\
                    \}\
                    if ("ap".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (onhand == woodpickaxe1) \{\
                            if (woodpickaxe == true) \{\
                                if (gameTable[i][j - 1] == stone) \{\
                                    prochwoodpickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j - 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == hamer1) \{\
                            if (hamer == true) \{\
                                if (gameTable[i][j - 1] == stenkawood) \{\
                                    prochhamer--;\
                                    stenkawoodcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j - 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i][j - 1] == iron) \{\
                                    prochstonepickaxe--;\
                                    ironcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j - 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i][j - 1] == gold) \{\
                                    prochstonepickaxe--;\
                                    goldcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j - 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i][j - 1] == stone) \{\
                                    prochstonepickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j - 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i][j - 1] == iron) \{\
                                    prochironpickaxe--;\
                                    ironcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j - 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i][j - 1] == gold) \{\
                                    prochironpickaxe--;\
                                    goldcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j - 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i][j - 1] == stone) \{\
                                    prochironpickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j - 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
\
                        if (gameTable[i][j - 1] == tree) \{\
                            woodcolvo++;\
                            int aple = (int) (Math.random() * 4);\
                            if (aple == 3) \{\
                                applecolvo++;\
                            \}\
                            object = EMPTY;\
                            gameTable[i][j - 1] = object;\
                            pole();\
                        \}\
                        if (gameTable[i][j - 1] == star) \{\
                            invstarcolvo++;\
                            starcolvo = 0;\
                            object = EMPTY;\
                            gameTable[i][j - 1] = object;\
                            pole();\
                        \} else \{\
                            System.out.println("you cant breake this block");\
                            pole();\
                        \}\
                    \}\
                    if ("wp".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (onhand == woodpickaxe1) \{\
                            if (woodpickaxe == true) \{\
                                if (gameTable[i - 1][j] == stone) \{\
                                    prochwoodpickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i - 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == hamer1) \{\
                            if (hamer == true) \{\
                                if (gameTable[i - 1][j] == stenkawood) \{\
                                    prochhamer--;\
                                    stenkawoodcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i - 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i - 1][j] == iron) \{\
                                    prochstonepickaxe--;\
                                    ironcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i - 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i - 1][j] == gold) \{\
                                    prochstonepickaxe--;\
                                    goldcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i - 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i - 1][j] == stone) \{\
                                    prochstonepickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i - 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i - 1][j] == iron) \{\
                                    prochironpickaxe--;\
                                    ironcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i - 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i - 1][j] == gold) \{\
                                    prochironpickaxe--;\
                                    goldcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i - 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i - 1][j] == stone) \{\
                                    prochironpickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i - 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (gameTable[i - 1][j] == tree) \{\
                            woodcolvo++;\
                            int aple = (int) (Math.random() * 4);\
                            if (aple == 3) \{\
                                applecolvo++;\
                            \}\
                            object = EMPTY;\
                            gameTable[i - 1][j] = object;\
                            pole();\
                        \}\
                        if (gameTable[i - 1][j] == star) \{\
                            invstarcolvo++;\
                            starcolvo = 0;\
                            object = EMPTY;\
                            gameTable[i - 1][j] = object;\
                            pole();\
                        \} else \{\
                            System.out.println("you cant breake this block");\
                            pole();\
                        \}\
                    \}\
                    if ("sp".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (onhand == woodpickaxe1) \{\
                            if (woodpickaxe == true) \{\
                                if (gameTable[i + 1][j] == stone) \{\
                                    prochwoodpickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i + 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == hamer1) \{\
                            if (hamer == true) \{\
                                if (gameTable[i + 1][j] == stenkawood) \{\
                                    prochhamer--;\
                                    stenkawoodcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i + 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i + 1][j] == iron) \{\
                                    prochstonepickaxe--;\
                                    ironcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i + 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (gameTable[i + 1][j] == gold) \{\
                                if (stonepickaxe == true) \{\
                                    prochstonepickaxe--;\
                                    goldcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i + 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i + 1][j] == stone) \{\
                                    prochstonepickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i + 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i][j + 1] == iron) \{\
                                    prochironpickaxe--;\
                                    ironcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i + 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i + 1][j] == gold) \{\
                                    prochironpickaxe--;\
                                    goldcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i + 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i + 1][j] == stone) \{\
                                    prochironpickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i + 1][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
\
                        if (gameTable[i + 1][j] == tree) \{\
                            woodcolvo++;\
                            int aple = (int) (Math.random() * 4);\
                            if (aple == 3) \{\
                                applecolvo++;\
                            \}\
                            object = EMPTY;\
                            gameTable[i + 1][j] = object;\
                            pole();\
                        \}\
                        if (gameTable[i + 1][j] == star) \{\
                            invstarcolvo++;\
                            starcolvo = 0;\
                            object = EMPTY;\
                            gameTable[i + 1][j] = object;\
                            pole();\
                        \} else \{\
                            System.out.println("you cant breake this block");\
                            pole();\
                        \}\
                    \}\
                    if ("dp".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (onhand == woodpickaxe1) \{\
                            if (woodpickaxe == true) \{\
                                if (gameTable[i][j + 1] == stone) \{\
                                    stonecolvo++;\
                                    prochwoodpickaxe--;\
                                    object = EMPTY;\
                                    gameTable[i][j + 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == hamer1) \{\
                            if (hamer == true) \{\
                                if (gameTable[i][j + 1] == stenkawood) \{\
                                    prochhamer--;\
                                    stenkawoodcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j + 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i][j + 1] == iron) \{\
                                    prochstonepickaxe--;\
                                    ironcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j + 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i][j + 1] == gold) \{\
                                    prochstonepickaxe--;\
                                    goldcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j + 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == stonepickaxe1) \{\
                            if (stonepickaxe == true) \{\
                                if (gameTable[i][j + 1] == stone) \{\
                                    prochstonepickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j + 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i][j + 1] == iron) \{\
                                    prochironpickaxe--;\
                                    ironcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j + 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i][j + 1] == gold) \{\
                                    prochironpickaxe--;\
                                    goldcolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j + 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (onhand == ironpickaxe1) \{\
                            if (ironpickaxe == true) \{\
                                if (gameTable[i][j + 1] == stone) \{\
                                    prochironpickaxe--;\
                                    stonecolvo++;\
                                    object = EMPTY;\
                                    gameTable[i][j + 1] = object;\
                                    pole();\
                                \}\
                            \}\
                        \}\
                        if (gameTable[i][j + 1] == tree) \{\
                            woodcolvo++;\
                            int aple = (int) (Math.random() * 4);\
                            if (aple == 3) \{\
                                applecolvo++;\
                            \}\
                            object = EMPTY;\
                            gameTable[i][j + 1] = object;\
                            pole();\
                        \}\
                        if (gameTable[i][j + 1] == star) \{\
                            invstarcolvo++;\
                            starcolvo = 0;\
                            object = EMPTY;\
                            gameTable[i][j + 1] = object;\
                            pole();\
                        \} else \{\
                            System.out.println("you cant breake this block");\
                            pole();\
                        \}\
                    \}\
                    if ("u".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        if (onhand == secretweapon) \{\
                            object = EMPTY;\
                            gameTable[i][j + 1] = object;\
                            gameTable[i][j - 1] = object;\
                            gameTable[i - 1][j] = object;\
                            gameTable[i + 1][j] = object;\
                            gameTable[i+1][j-1] = object;\
                            gameTable[i-1][j+1] = object;\
                            System.out.println();\
                            pole();\
                        \}\
                    \}\
                    if ("do".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (gameTable[i][j + 1] == EMPTY) \{\
                            if (onhand == stenkawood) \{\
                                stenkawoodcolvo--;\
                                object = stenkawood;\
                                gameTable[i][j + 1] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("You cant place this here");\
                            pole();\
                        \}\
                        if (gameTable[i][j + 1] == EMPTY) \{\
                            if (onhand == chest) \{\
                                chestcolvo--;\
                                object = chest;\
                                gameTable[i][j + 1] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("You cant place this here");\
                            pole();\
                        \}\
                    \}\
                    if ("ao".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (gameTable[i][j - 1] == EMPTY) \{\
                            if (onhand == stenkawood) \{\
                                stenkawoodcolvo--;\
                                object = stenkawood;\
                                gameTable[i][j - 1] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("You cant place this here");\
                            pole();\
                        \}\
\
                        if (gameTable[i][j - 1] == EMPTY) \{\
                            if (onhand == chest) \{\
                                chestcolvo--;\
                                object = chest;\
                                gameTable[i][j - 1] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("You cant place this here");\
                            pole();\
                        \}\
                    \}\
\
                    \
                    if ("wo".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (gameTable[i - 1][j] == EMPTY) \{\
                            if (onhand == stenkawood) \{\
                                stenkawoodcolvo--;\
                                object = stenkawood;\
                                gameTable[i - 1][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("You cant place this here");\
                            pole();\
                        \}\
                        if (gameTable[i - 1][j] == EMPTY) \{\
                            if (onhand == chest) \{\
                                chestcolvo--;\
                                object = chest;\
                                gameTable[i - 1][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("You cant place this here");\
                            pole();\
                        \}\
                    \}\
\
                    if ("so".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (gameTable[i + 1][j] == EMPTY) \{\
                            if (onhand == stenkawood) \{\
                                stenkawoodcolvo--;\
                                object = stenkawood;\
                                gameTable[i + 1][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("You cant place this here");\
                            pole();\
                        \}\
                        if (gameTable[i + 1][j] == EMPTY) \{\
                            if (onhand == chest) \{\
                                chestcolvo--;\
                                object = chest;\
                                gameTable[i + 1][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("You cant place this here");\
                            pole();\
                        \}\
                    \}\
\
                    if ("d".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (gameTable[i][j + 1] == EMPTY || gameTable[i][j + 1] == grass) \{\
                            if (gameTable[i][j + 1] == grass) \{\
                                object = player;\
                                gameTable[i][j + 1] = object;\
                                object = grass;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \}\
                        if (gameTable[i][j + 1] == EMPTY || gameTable[i][j + 1] == grass) \{\
                            if (gameTable[i][j + 1] == EMPTY) \{\
                                object = player;\
                                gameTable[i][j + 1] = object;\
                                object = EMPTY;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("sorry its not EMPTY");\
                            pole();\
                        \}\
                    \}\
                    if ("a".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (gameTable[i][j - 1] == EMPTY || gameTable[i][j - 1] == grass) \{\
                            if (gameTable[i][j - 1] == grass) \{\
                                object = player;\
                                gameTable[i][j - 1] = object;\
                                object = grass;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                            if (gameTable[i][j - 1] == EMPTY || gameTable[i][j - 1] == grass) \{\
                                if (gameTable[i][j - 1] == EMPTY) \{\
                                    object = player;\
                                    gameTable[i][j - 1] = object;\
                                    object = EMPTY;\
                                    gameTable[i][j] = object;\
                                    pole();\
                                \}\
                            \}\
                        \} else \{\
                            System.out.println("sorry its not EMPTY");\
                            pole();\
                        \}\
                    \}\
                    if ("w".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (gameTable[i - 1][j] == EMPTY || gameTable[i - 1][j] == grass) \{\
                            if (gameTable[i - 1][j] == grass) \{\
                                object = player;\
                                gameTable[i - 1][j] = object;\
                                object = grass;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \}\
                        if (gameTable[i - 1][j] == EMPTY || gameTable[i - 1][j] == grass) \{\
                            if (gameTable[i - 1][j] == EMPTY) \{\
                                object = player;\
                                gameTable[i - 1][j] = object;\
                                object = EMPTY;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("sorry its not EMPTY");\
                            pole();\
                        \}\
                    \}\
                    if ("s".equals(vibor)) \{\
                        autosave++;\
                        time++;\
                        hungry--;\
                        if (gameTable[i + 1][j] == EMPTY || gameTable[i + 1][j] == grass) \{\
                            if (gameTable[i + 1][j] == EMPTY) \{\
                                object = player;\
                                gameTable[i + 1][j] = object;\
                                object = EMPTY;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \}\
                        if (gameTable[i + 1][j] == EMPTY || gameTable[i + 1][j] == grass) \{\
                            if (gameTable[i + 1][j] == grass) \{\
                                object = player;\
                                gameTable[i + 1][j] = object;\
                                object = grass;\
                                gameTable[i][j] = object;\
                                pole();\
                            \}\
                        \} else \{\
                            System.out.println("sorry its not EMPTY");\
                            pole();\
                        \}\
                    \}\
                    if ("e".equals(vibor))\{\
                        autosave++;\
                        for (i = 0; i < SIZE;i++)\{\
                            for (j = 0; j < SIZE; j++)\{\
                                 if (gameTable[i][j] == player)\{\
                                     if (gameTable[i][j+1] == chest)\{\
                                         chestmenu();\
                                     \}\
                                     if (gameTable[i][j-1] == chest)\{\
                                         chestmenu();\
                                     \}\
                                     if (gameTable[i+1][j-1] == chest)\{\
                                         chestmenu();\
                                     \}\
                                     if (gameTable[i-1][j+1] == chest)\{\
                                         chestmenu();\
                                     \}\
                                 \}\
                        \}\
                        \}\
                        pole();\
                    \}\
                \}\
            \}\
        \}\
    \}\
\
    public static void pole() \{\
        for (int i = 0; i < SIZE; i++) \{\
            for (int j = 0; j < SIZE; j++) \{\
                System.out.print(gameTable[i][j]);\
            \}\
            System.out.println();\
        \}\
        xodplayer();\
    \}\
\
    public static void chestmenu()\{\
        System.out.println(chestinv1 + " " + chestinv1colvo);\
        System.out.println(chestinv2 + " " + chestinv2colvo);\
        System.out.println(chestinv3 + " " + chestinv3colvo);\
        System.out.println(chestinv4 + " " + chestinv4colvo);\
        System.out.println(chestinv5 + " " + chestinv5colvo);\
        System.out.println("what item do you want to chose:");\
         char vib = new Scanner(System.in).nextLine().charAt(0);\
        if (vib == 'W')\{\
            System.out.println("put or take");\
             char pt = new Scanner(System.in).nextLine().charAt(0);\
             if (pt == 'T')\{\
                 System.out.println("col-vo:");\
                 int takecolvo = new Scanner(System.in).nextInt();\
               \
                 if (chestinv1colvo < takecolvo)\{\
                     System.out.println("you dont have that colvo");\
                 \}\
                 double woodchestcolvo = chestinv1colvo;\
                 chestinv1colvo = chestinv1colvo - takecolvo;\
                 woodcolvo = woodchestcolvo;\
                 pole();\
             \}\
             if (pt == 'P')\{\
                 System.out.println("col-vo:");\
                 int putcolvo = new Scanner(System.in).nextInt();\
                 chestinv1 = wood;\
                chestinv1colvo = chestinv1colvo + putcolvo;\
                 woodcolvo = woodcolvo - putcolvo;\
                 pole();\
             \}\
        \}\
        if (vib == 'S')\{\
            System.out.println("put or take");\
             char pt = new Scanner(System.in).nextLine().charAt(0);\
             if (pt == 'T')\{\
                 System.out.println("col-vo:");\
                 int takecolvo = new Scanner(System.in).nextInt();\
               \
                 if (chestinv2colvo < takecolvo)\{\
                     System.out.println("you dont have that colvo");\
                 \}\
                 double stonechestcolvo = chestinv2colvo;\
                 chestinv2colvo = chestinv2colvo - takecolvo;\
                 stonecolvo = stonechestcolvo;\
                 pole();\
             \}\
             if (pt == 'P')\{\
                 System.out.println("col-vo:");\
                 int putcolvo = new Scanner(System.in).nextInt();\
                 chestinv2 = stone;\
                chestinv2colvo = chestinv2colvo + putcolvo;\
                 stonecolvo = stonecolvo - putcolvo;\
                 pole();\
             \}\
        \}\
    \}\
    \
    public static void mainmenu() \{\
        System.out.println("Hello, Welcome To The Javaworld");\
        System.out.println("press [1] to start new game");\
        System.out.println("press [2] to load game");\
        System.out.println("press [3] to delete saved game");\
        System.out.println("press [4] to quit");\
        int option = new Scanner(System.in).nextInt();\
        if (option == 1) \{\
            createworld();\
        \}\
        if (option == 2) \{\
            load();\
        \}\
        if (option == 3) \{\
            deleteworld();\
        \}\
        if (option == 4) \{\
\
        \}\
    \}\
\
    public static void main(String[] args) \{\
        mainmenu();\
    \}\
\}}