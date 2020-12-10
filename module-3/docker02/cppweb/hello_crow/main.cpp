#include "crow_all.h"

using namespace std;

int main(int argc, char** argv)
{
    crow::SimpleApp app;

    CROW_ROUTE(app, "/")
        ([]() {
            return "<div><h1>Hello Crow</h1></div>";
        });

    char* port = getenv("PORT");
    uint16_t iPort = static_cast<uint16_t>(port != nullptr ? stoi(port) : 18080);
    cout << "PORT: " << iPort << "\n";

    app.port(iPort).multithreaded().run();
}