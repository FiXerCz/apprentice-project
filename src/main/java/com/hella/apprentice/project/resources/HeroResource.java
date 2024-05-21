package com.hella.apprentice.project.resources;

import com.hella.apprentice.project.enums.Race;
import com.hella.apprentice.project.pojos.Hero;
import com.hella.apprentice.project.services.HeroService;
import com.hella.apprentice.project.services.ImportService;
import com.hella.apprentice.project.utils.Constants;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path(Constants.PATH_HERO)
public class HeroResource {

    @Inject HeroService heroService;
    @Inject ImportService importService;

    @Inject Template hero;
    @Inject Template addHero;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance getAllHeroes() {
        return hero.data("heroes", heroService.getAllHeroes());
    }

    @Path("add")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance addHero() {
        return addHero.instance();
    }

    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public TemplateInstance add(MultivaluedMap<String,String> form) {

        Race race = Race.byName(form.getFirst("race"));

        Hero newHero = new Hero.HeroBuilder()
                .setName(form.getFirst("name"))
                .setAttack(Integer.parseInt(form.getFirst("attack")))
                .setDefense(Integer.parseInt(form.getFirst("defense")))
                .setHp(Integer.parseInt(form.getFirst("hp")))
                .setRace(race).build();
        heroService.addHero(newHero);

        return hero.data("heroes", heroService.getAllHeroes());
    }

    @Path("delete/{name}")
    @GET
    public Response delete(@PathParam("name") String heroName) {
        heroService.removeHero(heroName);
        return Response.temporaryRedirect(URI.create("/hero")).build();
    }

    @Path("import")
    @GET
    public Response importHeroes() {
        importService.importHeroesFromFile();
        return Response.temporaryRedirect(URI.create("/hero")).build();
    }

}
