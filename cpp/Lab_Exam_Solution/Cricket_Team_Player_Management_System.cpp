#include <iostream>
#include <vector>
#include <algorithm>
#include <istream>
#include <string>
using namespace std;

enum class TeamNames
{
    MI = 1,
    CSK,
    RCB,
    KKR,
    KXIP
};

class Match
{
private:
    int matchId;
    int runs_scored;

public:
    Match():matchId(0), runs_scored(0)
    {
    }

    int getMatchId() const
    {
        return this->matchId;
    }

    void setMatchId(int mid)
    {
        this->matchId = mid;
    }

    int getRuns_scored() const
    {
        return this->runs_scored;
    }

    void setRuns_scored(int runs_scored)
    {
        this->runs_scored = runs_scored;
    }
};

class Player
{
private:
    int playerId;
    string playerName;
    vector<Match *> perMatchRuns;

public:
    Player() {}

    int getPlayerId()
    {
        return playerId;
    }

    string getPlayerName()
    {
        return playerName;
    }

    void acceptPlayer()
    {
        cout << "Enter Players ID - " << endl;
        cin >> playerId;
        cout << "Enter Players Name - " << endl;
        cin.ignore();
        getline(cin, playerName);
    }
    void displayPlayer()
    {
        cout << "Players ID - " << playerId << endl;
        cout << "Players Name - " << playerName << endl;
        for (int i = 0; i < perMatchRuns.size(); i++)
        {
            cout << "Runs of - " << i+1 << " Match is :" << perMatchRuns[i]->getRuns_scored() << endl;
        }
        cout << "**********************************************" << endl;
    }

    void addMatchRuns()
    {
        int noOfMatchs;
        cout<<"How many Match runs you want to add"<<endl;
        cin>>noOfMatchs;
        for (int i = 0; i < noOfMatchs; i++)
        {
            int matchId;
            int matchRuns;
            Match *runs = new Match();
            cout << "Enter Match ID of No. " << i+1 << " Match" << endl;
            cin >> matchId;
            cout << "Enter Runs for No. " << i+1 << " Match" << endl;
            cin >> matchRuns;
            runs->setMatchId(matchId);
            runs->setRuns_scored(matchRuns);
            perMatchRuns.push_back(runs);
        }
        cout << "**************************************" << endl;
    }

    ~Player()
    {
        for (Match *match : perMatchRuns)
        {
            delete match;  // Free each Match object
        }
        perMatchRuns.clear();  // Clear the vector
    }
};

class Team
{
private:
    vector<Player *> players;

public:
private:
    int teamId;
    TeamNames teamName;

public:
    Team(){};

    int getTeamId()
    {
        return this->teamId;
    }

    void acceptTeam()
    {
        cout << "Enter Team id :" << endl;
        cin >> this->teamId;
        int choice;
        cout << "Enter Team (1. MI, 2. CSK, 3. RCB, 4. KKR, 5. KXIP): " << endl;
        cin >> choice;
        if (choice == 1)
            this->teamName = TeamNames::MI;
        else if (choice == 2)
            this->teamName = TeamNames::CSK;
        else if (choice == 3)
            this->teamName = TeamNames::RCB;
        else if (choice == 4)
            this->teamName = TeamNames::KKR;
        else if (choice == 5)
            this->teamName = TeamNames::KXIP;
        else
        {
            cout << "Invalid input!!!" << endl;
        }
    }

    void displayTeam() const
    {
        cout << "Team id is :" << teamId << endl;
        cout << "Team Name is : ";
        switch (teamName)
        {
        case TeamNames::MI:
            cout << "Mumbai Indians " << endl;
            cout << "##############################################" << endl;
            break;
        case TeamNames::CSK:
            cout << "Chennai Super Kings " << endl;
            cout << "##############################################" << endl;
            break;
        case TeamNames::RCB:
            cout << "Royal Challengers Bangalore " << endl;
            cout << "##############################################" << endl;
            break;
        case TeamNames::KKR:
            cout << "Kolkatta Knight Riders " << endl;
            cout << "##############################################" << endl;
            break;
        case TeamNames::KXIP:
            cout << "Kings Eleven Punjab " << endl;
            cout << "##############################################" << endl;
            break;
        }
    }
    void addPlayer(Player *player)
    {
        players.push_back(player);
        cout << "Player with ID " << player->getPlayerId() << " added to Team with ID " << teamId << endl;
    }
    vector<Player *> &getPlayers()
    {
        return players;
    }

     ~Team()  // Destructor to free dynamically allocated Player objects
    {
        for (Player *player : players)
        {
            delete player;  // Free each Player object
        }
        players.clear();  // Clear the vector
    }
};

void displayAllTeam(vector<Team *> &team_list)
{
    for (int i = 0; i < team_list.size(); i++)
        team_list[i]->displayTeam();
}

void displayAllPlayers(vector<Player *> &player_list)
{
    cout<<"All Registered Players List"<<endl;
    cout << "**********************************************" << endl;
    for (int i = 0; i < player_list.size(); i++)
        player_list[i]->displayPlayer();
}

void AddMatchRunsToPlayer(vector<Player *> &players_list)
{
    cout<<"Inside AddMatchRunsToPlayer "<<endl;
    for (int i = 0; i < players_list.size(); i++)
    {
        cout<<"Add Player No. "<< i+1 <<" "<< players_list[i]->getPlayerName()<< "'s" << " Match Runs:"<<endl;
        players_list[i]->addMatchRuns();
    }
}

void AddPlayerToTeam(vector<Team *> &team_list, vector<Player *> &player_list)
{
    displayAllPlayers(player_list);
    int playerId;
    cout << "Enter Player ID to Add Team - " << endl;
    cin >> playerId;
    bool found=false;
    cout << "**********************************************" << endl;
    cout<<"All Registered Team List"<<endl;
    for (int i = 0; i < player_list.size(); i++)
    {
        if (playerId == player_list[i]->getPlayerId())
        {
            found = true;
            cout << "###############################################" << endl;
            
            displayAllTeam(team_list);
            int teamId;
            cout << "Enter the Team id to add Player - " << endl;
            cin >> teamId;
            for (int j = 0; j < team_list.size(); j++)
            {
                if (teamId == team_list[j]->getTeamId())
                {
                    // team_list[j]->addPlayer(player_list[i]);
                        
                    // or

                    team_list[j]->getPlayers().push_back(player_list[i]);
                    cout << "Player added to Team successfully" << endl;
                    return;
                }
            }
            break;
        }
    }
    if(!found){
    cout << "Player not found..." << endl;
    }
}

void displayAllTeamsAlongWithPlayersAndRuns(vector<Team *> &team_list)
{

    for (int i = 0; i < team_list.size(); i++)
    {
        team_list[i]->displayTeam();
        displayAllPlayers(team_list[i]->getPlayers());
    }
}

int menu()
{
    int choice;
    cout << "**********************************************" << endl;
    cout << "0. EXIT" << endl;
    cout << "1. Register Player" << endl;
    cout << "2. Display All Registered Players" << endl;
    cout << "3. Register Team" << endl;
    cout << "4. Display All Team" << endl;
    cout << "5. Add Matches played by the given player" << endl;
    cout << "6. Add Player to Team" << endl;
    cout << "7. Display all Teams along with Players and their Matches played" << endl;
    cout << "Enter your choice - ";
    cin >> choice;
    cout << "**********************************************" << endl;
    return choice;
}

int main()
{
    vector<Player *> players_list;
    vector<Team *> team_list;
    bool runsAdded = false;
    int choice;
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
        {
            Player *player = new Player();
            player->acceptPlayer();
            players_list.push_back(player);
            cout<<"Player Registered Successfully"<<endl;
            break;
        }
        case 2:
        {
            for (int i = 0; i < players_list.size(); i++)
                players_list[i]->displayPlayer();
            break;
        }
        case 3:
        {
            Team *team = new Team();
            team->acceptTeam();
            team_list.push_back(team);
            cout<<"Team Registered Successfully"<<endl;
            break;
        }
        case 4:
        {
            for (int i = 0; i < team_list.size(); i++)
                team_list[i]->displayTeam();
            break;
        }
        case 5:
        {
            AddMatchRunsToPlayer(players_list);
            runsAdded = true;
            break;
        }
        case 6:
        {
            if (runsAdded)
            {
                AddPlayerToTeam(team_list, players_list);
               // cout << "\nAll Classrooms Along with Students: " << endl;
            }
            else
            {
                cout << "Run Case 5 First to add no. of matches played and runs scored by each player" << endl;
            }
            break;
        }

        case 7:
        {
            displayAllTeamsAlongWithPlayersAndRuns(team_list);
            break;
        }
        }
    }
    for (Player *player : players_list)
    {
        delete player;
    }
    players_list.clear();

    for (Team *team : team_list)
    {
        delete team;
    }
    team_list.clear();
}