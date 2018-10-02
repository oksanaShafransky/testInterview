package FileSystemTest;

public class File extends Entry {
    private String content;
    private String type;
    private long size;

    public File(String name, String type, Directory directory, int size) {
        super(name, directory);
        this.type=type;
        this.size=size;
    }

    @Override
    public long size() {
        return 0;
    }

    //getters/setters
}
