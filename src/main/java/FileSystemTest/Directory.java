package FileSystemTest;

public class Directory extends Entry {
    public Directory(String name, String path, long size){
        super(name, null);
    }

    @Override
    public long size() {
        return 0;
    }
}
