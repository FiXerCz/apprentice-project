package com.hella.apprentice.project.resources;

import com.hella.apprentice.project.logic.Round;
import com.hella.apprentice.project.services.HeroService;
import com.hella.apprentice.project.logic.Tournament;
import com.hella.apprentice.project.utils.Constants;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Path("/")
@RequestScoped
public class GameResource {

    @Inject
    HeroService heroService;

    @Inject
    Template game;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance homePage() {
        Map<String, Object> data = new HashMap<>();
        data.put("gameStarted", Tournament.getInstance().isStarted());
        data.put("gameFinished", Tournament.getInstance().isFinished());

        if (Tournament.getInstance().isStarted()) {
            data.put("ranking", Tournament.getInstance().getRankings());
            data.put("rounds", Tournament.getInstance().getRounds());
        }
        return game.data(data);
    }

    @GET
    @Path(Constants.PATH_GAME + "/start")
    public Response startNewGame() {
        Tournament.getInstance().startTournament(heroService.getAllHeroes());
        return Response.temporaryRedirect(URI.create("/")).build();
    }

    @GET
    @Path(Constants.PATH_GAME + "/play")
    public Response nextRound() {
        Round r = Tournament.getInstance().addRound();
        r.playRound();
        return Response.temporaryRedirect(URI.create("/")).build();
    }

}
