# 🖥️ Remote Desktop Viewer - Java & JavaFX

A simple **Remote Desktop Viewer** built using **Java**, **JavaFX**, and **Socket Programming**.  
It allows real-time screen sharing by capturing and sending screenshots from a remote system to a viewer every 200 milliseconds.

---

## 🚀 Features

- 📸 Real-time screen sharing (screenshot every 200ms)
- 🔌 Lightweight socket-based communication
- 🎨 JavaFX-based GUI for a smooth viewing experience
- 🌐 Works on LAN (same Wi-Fi or network)

---

## 🛠️ Technologies Used

- Java (Core + AWT + I/O)
- JavaFX (Front-end GUI)
- Socket Programming (TCP/IP)

---

## 🖥️ How It Works

1. The **server PC** (the one being monitored) captures its screen every 200 milliseconds.
2. The screenshots are sent through a socket connection to the **client PC** (the one monitoring).
3. The **client PC** displays these images in real-time using JavaFX, creating a smooth remote viewing experience.

---

## 🧰 Requirements

### For Server (Monitored PC)
- Java JDK 8 or higher
- VS Code (recommended)
- No need for JavaFX setup

### For Client (Monitoring PC)
- Java JDK 8 or higher
- JavaFX SDK properly set up and configured in your IDE (e.g., IntelliJ or VS Code)

📌 **Note:** Both computers must be connected to the **same network** (e.g., same Wi-Fi or LAN).

---

## 🧪 How to Run the Project

### 1. Start the Server (on the PC you want to monitor):
- Open the project folder in **VS Code**
- Run the `Server.java` file

### 2. Start the Client (on the PC doing the monitoring):
- Make sure **JavaFX SDK** is properly configured
- Run the `Client.java` file
- Enter the **IP address** of the server PC when prompted

---

## 📸 Preview


<img width="1366" height="768" alt="monitor" src="https://github.com/user-attachments/assets/08423a2e-39de-40bc-970a-5f15c57a2d40" />



## 📌 Limitations

- Both PCs must be on the same local network
- Currently no input control (mouse/keyboard)—only viewing

---

## 🙌 Future Improvements

- Secure communication (TLS)
- Support for WAN/remote IP access
- Add control functionality (mouse + keyboard)
- Optimize bandwidth and image compression

---

## 👨‍💻 Author

**Muhammad Idrees**  
BS Software Engineering, COMSATS University, Islamabad  
💡 Passionate about building real-time and intelligent software systems

---

## 🤝 License

This project is open-source and can be used by anyone for educational or commercial purposes 

---

