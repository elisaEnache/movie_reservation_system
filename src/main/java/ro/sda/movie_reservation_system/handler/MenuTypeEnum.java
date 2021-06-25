package ro.sda.movie_reservation_system.handler;


public enum MenuTypeEnum {
    UNKNOWN(-1),
    MAIN_MENU(0),
    DASHBOARD_MENU(1),
    USER_MENU(2),
    MOVIES_MENU(3),
    PROJECTION_ROOMS_MENU(4),
    RESERVATIONS(5);


    private Integer option;

    MenuTypeEnum(Integer option) {
        this.option = option;
    }
    public static MenuTypeEnum getEnum(Integer option){
        for (MenuTypeEnum menuTypeEnum: MenuTypeEnum.values()){
            if (menuTypeEnum.option ==  option){
                return menuTypeEnum;
            }
        }
        return UNKNOWN;
    }
}
