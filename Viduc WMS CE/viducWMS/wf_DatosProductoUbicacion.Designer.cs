namespace viducWMS
{
    partial class wf_DatosProductoUbicacion
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.txbUbicacion = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txbDescripcion = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txbCantidad = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txbCodProducto = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txbCantidadReal = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.btnAceptar = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // txbUbicacion
            // 
            this.txbUbicacion.ForeColor = System.Drawing.Color.Navy;
            this.txbUbicacion.Location = new System.Drawing.Point(116, 115);
            this.txbUbicacion.MaxLength = 200;
            this.txbUbicacion.Name = "txbUbicacion";
            this.txbUbicacion.ReadOnly = true;
            this.txbUbicacion.Size = new System.Drawing.Size(109, 21);
            this.txbUbicacion.TabIndex = 5;
            this.txbUbicacion.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txbUbicacion_KeyUp);
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label1.ForeColor = System.Drawing.Color.Navy;
            this.label1.Location = new System.Drawing.Point(32, 117);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(69, 20);
            this.label1.Text = "Ubicación:";
            this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // txbDescripcion
            // 
            this.txbDescripcion.ForeColor = System.Drawing.Color.Navy;
            this.txbDescripcion.Location = new System.Drawing.Point(14, 161);
            this.txbDescripcion.MaxLength = 200;
            this.txbDescripcion.Multiline = true;
            this.txbDescripcion.Name = "txbDescripcion";
            this.txbDescripcion.ReadOnly = true;
            this.txbDescripcion.Size = new System.Drawing.Size(212, 38);
            this.txbDescripcion.TabIndex = 6;
            this.txbDescripcion.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txbDescripcion_KeyUp);
            // 
            // label2
            // 
            this.label2.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label2.ForeColor = System.Drawing.Color.Navy;
            this.label2.Location = new System.Drawing.Point(21, 144);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(81, 16);
            this.label2.Text = "Descripción:";
            this.label2.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // txbCantidad
            // 
            this.txbCantidad.ForeColor = System.Drawing.Color.Navy;
            this.txbCantidad.Location = new System.Drawing.Point(116, 81);
            this.txbCantidad.MaxLength = 200;
            this.txbCantidad.Name = "txbCantidad";
            this.txbCantidad.ReadOnly = true;
            this.txbCantidad.Size = new System.Drawing.Size(109, 21);
            this.txbCantidad.TabIndex = 4;
            this.txbCantidad.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txbCantidad_KeyUp);
            // 
            // label3
            // 
            this.label3.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label3.ForeColor = System.Drawing.Color.Navy;
            this.label3.Location = new System.Drawing.Point(40, 84);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(61, 16);
            this.label3.Text = "Cantidad:";
            this.label3.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // txbCodProducto
            // 
            this.txbCodProducto.ForeColor = System.Drawing.Color.Navy;
            this.txbCodProducto.Location = new System.Drawing.Point(116, 48);
            this.txbCodProducto.MaxLength = 200;
            this.txbCodProducto.Name = "txbCodProducto";
            this.txbCodProducto.ReadOnly = true;
            this.txbCodProducto.Size = new System.Drawing.Size(109, 21);
            this.txbCodProducto.TabIndex = 3;
            this.txbCodProducto.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txbCodProducto_KeyUp);
            // 
            // label4
            // 
            this.label4.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label4.ForeColor = System.Drawing.Color.Navy;
            this.label4.Location = new System.Drawing.Point(8, 50);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(100, 20);
            this.label4.Text = "Cód. Producto:";
            this.label4.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // txbCantidadReal
            // 
            this.txbCantidadReal.ForeColor = System.Drawing.Color.Navy;
            this.txbCantidadReal.Location = new System.Drawing.Point(116, 218);
            this.txbCantidadReal.MaxLength = 15;
            this.txbCantidadReal.Name = "txbCantidadReal";
            this.txbCantidadReal.Size = new System.Drawing.Size(109, 21);
            this.txbCantidadReal.TabIndex = 0;
            this.txbCantidadReal.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txbCantidadReal_KeyUp);
            // 
            // label6
            // 
            this.label6.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label6.ForeColor = System.Drawing.Color.Navy;
            this.label6.Location = new System.Drawing.Point(9, 221);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(100, 18);
            this.label6.Text = "Cantidad Fisica:";
            this.label6.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // btnAceptar
            // 
            this.btnAceptar.BackColor = System.Drawing.Color.Navy;
            this.btnAceptar.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnAceptar.ForeColor = System.Drawing.Color.White;
            this.btnAceptar.Location = new System.Drawing.Point(10, 261);
            this.btnAceptar.Name = "btnAceptar";
            this.btnAceptar.Size = new System.Drawing.Size(83, 30);
            this.btnAceptar.TabIndex = 1;
            this.btnAceptar.Text = "Aceptar";
            this.btnAceptar.Click += new System.EventHandler(this.btnAceptar_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.Navy;
            this.btnSalir.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnSalir.ForeColor = System.Drawing.Color.White;
            this.btnSalir.Location = new System.Drawing.Point(143, 262);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(83, 30);
            this.btnSalir.TabIndex = 2;
            this.btnSalir.Text = "Cancelar";
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // label5
            // 
            this.label5.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label5.ForeColor = System.Drawing.Color.Navy;
            this.label5.Location = new System.Drawing.Point(9, 17);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(218, 15);
            this.label5.Text = "Detalles del Producto ";
            this.label5.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // wf_DatosProductoUbicacion
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.ControlBox = false;
            this.Controls.Add(this.label5);
            this.Controls.Add(this.btnAceptar);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.txbCantidadReal);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.txbCodProducto);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.txbCantidad);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txbDescripcion);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txbUbicacion);
            this.Controls.Add(this.label1);
            this.Name = "wf_DatosProductoUbicacion";
            this.Text = "Producto Ubicación Inventario";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TextBox txbUbicacion;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txbDescripcion;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txbCantidad;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txbCodProducto;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txbCantidadReal;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button btnAceptar;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.Label label5;
    }
}