// Component
interface FileSystemComponent {
    fun display(): String
}

// Leaf
class File(private val name: String) : FileSystemComponent {
    override fun display(): String {
        return "File: $name"
    }
}

// Composite
class Directory(private val name: String) : FileSystemComponent {
    private val components: MutableList<FileSystemComponent> = mutableListOf()

    fun addComponent(component: FileSystemComponent) {
        components.add(component)
    }

    override fun display(): String {
        val result = StringBuilder()
        result.append("Directory: $name\n")

        for (component in components) {
            result.append("  ${component.display()}\n")
        }

        return result.toString()
    }
}

// Client code
fun main() {
    val file1 = File("document.txt")
    val file2 = File("image.jpg")

    val directory1 = Directory("Folder 1")
    directory1.addComponent(file1)

    val directory2 = Directory("Folder 2")
    directory2.addComponent(file2)

    val rootDirectory = Directory("Root")
    rootDirectory.addComponent(directory1)
    rootDirectory.addComponent(directory2)

    println(rootDirectory.display())
}
