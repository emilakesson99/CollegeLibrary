public class FacadeFactory {
    /**
     * Factory cases for each library at a college
     *
     * @param campus
     * @return
     */
    public static LibraryFacade buildFactory(String campus) {
        LibraryFacade facade = null;
        switch (campus) {
            case "NORTH":
                facade = new LibraryFacade(DataWrapper_NorthCampusStanford.getInstance());
                break;
            case "SOUTH":
                /*facade = new LibraryFacade("South");*/
                break;

            default:
                break;
        }
        return facade;
    }
}