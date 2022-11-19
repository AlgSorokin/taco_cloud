package com.elster.tacos.data;

import com.elster.tacos.model.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
