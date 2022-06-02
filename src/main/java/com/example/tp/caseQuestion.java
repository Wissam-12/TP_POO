package com.example.tp;

public abstract class caseQuestion extends Cases {
    protected boolean visited;
    public abstract void actionAssocie (Joueur J);
    public abstract void changerQuestion(Joueur J);
    public abstract void setVisited(boolean i );
}
