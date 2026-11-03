CREATE TABLE categoria (
                           id BIGINT NOT NULL AUTO_INCREMENT,
                           nome VARCHAR(255),
                           descricao VARCHAR(255),
                           tipo VARCHAR(255),
                           ativo BOOLEAN,
                           PRIMARY KEY (id)
);

CREATE TABLE conta (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       nome VARCHAR(255),
                       tipo VARCHAR(255),
                       saldo_inicial DECIMAL(19,2),
                       ativo BOOLEAN,
                       PRIMARY KEY (id)
);

CREATE TABLE renda (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       conta_id BIGINT,
                       categoria_id BIGINT,
                       descricao VARCHAR(255),
                       valor DECIMAL(19,2),
                       recorrencia VARCHAR(255),
                       dia_mes INT,
                       dia_semana VARCHAR(255),
                       data_pontual DATE,
                       ativo BOOLEAN,
                       PRIMARY KEY (id),

                       INDEX idx_renda_conta_id (conta_id),
                       INDEX idx_renda_categoria_id (categoria_id),

                       CONSTRAINT fk_renda_conta
                           FOREIGN KEY (conta_id) REFERENCES conta(id),

                       CONSTRAINT fk_renda_categoria
                           FOREIGN KEY (categoria_id) REFERENCES categoria(id)
)