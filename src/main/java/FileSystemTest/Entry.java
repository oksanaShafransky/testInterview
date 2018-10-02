package FileSystemTest;

public abstract class Entry {
    protected long creationDate;
    protected String name;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String path;
    protected Directory parent;
    protected int permission;

    public Entry(String name, Directory parent){

    }

    public abstract long size();
    //getters/setters
}
