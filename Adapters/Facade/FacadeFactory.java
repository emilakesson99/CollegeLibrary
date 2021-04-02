public class FacadeFactory {
    /**
     * Factory cases for each librar and one instance
     * of a library if you only want to see your loans
     *
     * @param libraryName
     * @return
     */
    public static LibraryFacade buildFactory(String libraryName) {
        return switch (libraryName) {
            case "NORTH" -> new LibraryFacade(new DataWrapperUser("NORTH"));
            case "SOUTH" -> new LibraryFacade(new DataWrapperUser("SOUTH"));
            default -> new LibraryFacade(null);
        };
    }
}
