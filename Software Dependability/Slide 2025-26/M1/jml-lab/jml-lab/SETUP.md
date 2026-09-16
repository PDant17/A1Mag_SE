
# Setup

## Prerequisites
- Java JDK 21 (or compatible).
- Download OpenJML from [https://www.openjml.org](https://www.openjml.org).
- Unzip the archive and add the JML folder to the PATH.
- On Ubuntu do do not forget to install `libgomp1` using `sudo apt-get install libgomp1`.

## Installing Java

### Ubuntu
```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

### macOS

#### Option 1: Using Homebrew (Recommended)
1. Install Homebrew if you haven't already:
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
2. Install OpenJDK 21:
   ```bash
   brew install openjdk@21
   ```
3. Add Java to your PATH by adding this line to your shell configuration file (`~/.zshrc` or `~/.bash_profile`):
   ```bash
   export PATH="/opt/homebrew/opt/openjdk@21/bin:$PATH"
   export JAVA_HOME="/opt/homebrew/opt/openjdk@21"
   ```
4. Reload your shell configuration:
   ```bash
   source ~/.zshrc  # or source ~/.bash_profile
   ```

#### Option 2: Manual Installation
1. Download OpenJDK 21 from [Adoptium](https://adoptium.net/temurin/releases/?version=21)
2. Install the `.pkg` file
3. The installer will automatically configure the PATH

### Verify Java Installation
After installation, verify that Java is correctly installed:
```bash
java -version
javac -version
```

You should see output indicating Java 21 (or your chosen version).

## Download OpenJML
[https://github.com/OpenJML/OpenJML/releases/tag/21-0.16](https://github.com/OpenJML/OpenJML/releases/tag/21-0.16)

## Adding OpenJML to PATH

### Ubuntu
1. Open your terminal
2. Edit your shell configuration file:
   - For bash: `nano ~/.bashrc` or `nano ~/.bash_profile`
   - For zsh: `nano ~/.zshrc`
3. Add the following line at the end of the file:
   ```bash
   export PATH="$PATH:/path/to/openjml/folder"
   ```
   Replace `/path/to/openjml/folder` with the actual path where you extracted OpenJML.
4. Reload your shell configuration:
   ```bash
   source ~/.bashrc  # or ~/.zshrc for zsh users
   ```

### macOS
1. Open Terminal
2. Edit your shell configuration file:
   - For bash: `nano ~/.bash_profile`
   - For zsh (default on macOS Catalina+): `nano ~/.zshrc`
3. Add the following line at the end of the file:
   ```bash
   export PATH="$PATH:/path/to/openjml/folder"
   ```
   Replace `/path/to/openjml/folder` with the actual path where you extracted OpenJML.
4. Reload your shell configuration:
   ```bash
   source ~/.zshrc  # or ~/.bash_profile for bash users
   ```

**Alternative method for both Linux and macOS:**
You can also add the PATH temporarily for the current session:
```bash
export PATH="$PATH:/path/to/openjml/folder"
```

### Verify installation
```bash
java -version
openjml -version
```
