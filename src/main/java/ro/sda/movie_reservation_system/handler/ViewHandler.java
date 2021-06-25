package ro.sda.movie_reservation_system.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewHandler {
    private Map<MenuTypeEnum, List<String>> myMenus;

    public ViewHandler(){
        this.myMenus = new HashMap<>();
        myMenus.put(MenuTypeEnum.MAIN_MENU, new ArrayList<>());
        myMenus.get(MenuTypeEnum.MAIN_MENU).add("1. LOGIN");
        myMenus.get(MenuTypeEnum.MAIN_MENU).add("2. CREATE ACCOUNT");
        myMenus.get(MenuTypeEnum.MAIN_MENU).add("3. CLOSE APP");

        myMenus.put(MenuTypeEnum.DASHBOARD_MENU, new ArrayList<>());
        myMenus.get(MenuTypeEnum.DASHBOARD_MENU).add("1. SEE ALL USER OPTIONS");
        myMenus.get(MenuTypeEnum.DASHBOARD_MENU).add("2. SEE ALL MOVIE OPTIONS");
        myMenus.get(MenuTypeEnum.DASHBOARD_MENU).add("3. SEE ALL ROOM OPTIONS");
        myMenus.get(MenuTypeEnum.DASHBOARD_MENU).add("4. SEE ALL RESERVATION OPTIONS");
        myMenus.get(MenuTypeEnum.DASHBOARD_MENU).add("5. LOGOUT");

        myMenus.put(MenuTypeEnum.USER_MENU, new ArrayList<>());
        myMenus.get(MenuTypeEnum.USER_MENU).add("1. SEE ALL USERS");
        myMenus.get(MenuTypeEnum.USER_MENU).add("2. ADD USER");
        myMenus.get(MenuTypeEnum.USER_MENU).add("3. FIND USER BY ID");
        myMenus.get(MenuTypeEnum.USER_MENU).add("4. UPDATE USER EMAIL");
        myMenus.get(MenuTypeEnum.USER_MENU).add("5. DELETE USER ");
        myMenus.get(MenuTypeEnum.USER_MENU).add("6. GO BACK TO DASHBOARD");

        myMenus.put(MenuTypeEnum.MOVIES_MENU, new ArrayList<>());
        myMenus.get(MenuTypeEnum.MOVIES_MENU).add("1. SEE ALL MOVIES");
        myMenus.get(MenuTypeEnum.MOVIES_MENU).add("2. ADD MOVIE");
        myMenus.get(MenuTypeEnum.MOVIES_MENU).add("3. FIND MOVIE BY ID");
        myMenus.get(MenuTypeEnum.MOVIES_MENU).add("4. UPDATE MOVIE NAME");
        myMenus.get(MenuTypeEnum.MOVIES_MENU).add("5. DELETE MOVIE");
        myMenus.get(MenuTypeEnum.MOVIES_MENU).add("6. GO BACK TO DASHBOARD");


        myMenus.put(MenuTypeEnum.PROJECTION_ROOMS_MENU, new ArrayList<>());
        myMenus.get(MenuTypeEnum.PROJECTION_ROOMS_MENU).add("1. SEE ALL PROJECTION ROOMS");
        myMenus.get(MenuTypeEnum.PROJECTION_ROOMS_MENU).add("2. ADD PROJECTION ROOM");
        myMenus.get(MenuTypeEnum.PROJECTION_ROOMS_MENU).add("3. FIND PROJECTION ROOM BY ID");
        myMenus.get(MenuTypeEnum.PROJECTION_ROOMS_MENU).add("4. UPDATE PROJECTION ROOM");
        myMenus.get(MenuTypeEnum.PROJECTION_ROOMS_MENU).add("5. DELETE PROJECTION ROOM");
        myMenus.get(MenuTypeEnum.PROJECTION_ROOMS_MENU).add("6. GO BACK TO DASHBOARD");


        myMenus.put(MenuTypeEnum.RESERVATIONS, new ArrayList<>());
        myMenus.get(MenuTypeEnum.RESERVATIONS).add("1. SEE ALL RESERVATIONS");
        myMenus.get(MenuTypeEnum.RESERVATIONS).add("2. ADD RESERVATIONS");
        myMenus.get(MenuTypeEnum.RESERVATIONS).add("3. FIND RESERVATION BY ID");
        myMenus.get(MenuTypeEnum.RESERVATIONS).add("4. UPDATE RESERVATION MOVIE_ID");
        myMenus.get(MenuTypeEnum.RESERVATIONS).add("5. DELETE RESERVATION");
        myMenus.get(MenuTypeEnum.RESERVATIONS).add("6. GO BACK TO DASHBOARD");

    }

        public void printMenu(MenuTypeEnum typeEnum){
        for (String menu: myMenus.get(typeEnum)){
            System.out.println(menu);
        }
        }


}
